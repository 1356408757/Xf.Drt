package com.trust.xfyl.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.TrustFile;
import com.trust.xfyl.model.po.TrustFileExample;
import com.trust.xfyl.model.po.TrustRelationFileExample;
import com.trust.xfyl.service.impl.FileService;
import com.trust.xfyl.service.impl.YSkinService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/**
 * 文件上传、下载控制器
 *
 * @author Bay-max
 * @date 2024/4/22 15:14
 **/
@RestController
@Api(value = "图片处理", description = "图片处理", tags = "图片处理")
@RequestMapping("/uploaFile")
public class FileController {
    private static final Logger loggerInfo = null;
    private static String uploadImgUrl;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final TrustFileMapper trustFileMapper;
    private final YSkinService ySkinService;
    private final ExecutorService executorService;

    /**
     * 构造函数
     *
     * @param fileService             文件服务
     * @param trustRelationFileMapper 关系文件映射器
     * @param trustFileMapper         信任文件映射器
     * @param ySkinService            皮肤服务
     * @param executorService         执行服务
     */
    public FileController(FileService fileService, TrustRelationFileMapper trustRelationFileMapper, TrustFileMapper trustFileMapper, YSkinService ySkinService, ExecutorService executorService) {
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.trustFileMapper = trustFileMapper;
        this.ySkinService = ySkinService;
        this.executorService = executorService;
    }

    /**
     * 设置上传图片URL
     *
     * @param uploadImgUrl 上传图片的URL
     */
    @Value("${imageurl.uploadImgUrl}")
    public void setUploadImgUrl(String uploadImgUrl) {
        FileController.uploadImgUrl = uploadImgUrl;
    }

    /**
     * 新增文件信息
     *
     * @param files   文件列表
     * @param request HTTP请求对象
     * @return 返回文件上传结果
     * @throws IOException          输入输出异常
     * @throws NoSuchFieldException 无此字段异常
     * @throws ClientException      客户端异常
     */
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "新增文件信息", nickname = "addFile", notes = "新增文件信息")
    @ResponseBody
    @PostMapping(value = "/addFile", produces = "application/json;charset=utf-8")
    public String addFile(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request) throws IOException, NoSuchFieldException, ClientException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        fileService.upload(returnMap, files);
        /*上传图片到文件服务器并返回图片信息*/
        return mapper.writeValueAsString(returnMap);
    }

    /**
     * 下载文件
     *
     * @param fileName 文件名
     * @param response HTTP响应对象
     * @return 返回下载结果
     * @throws Exception 异常
     */
    @ApiOperation(value = "下载文件信息", nickname = "download", notes = "下载文件信息")
    @ResponseBody
    @GetMapping(value = "/download")
    public ResultVO downLoad(@ApiParam(name = "fileName", value = "文件名称", required = true) @RequestParam("fileName") String fileName, HttpServletResponse response) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        // 构造文件完整路径
        String filePath = uploadImgUrl + "/" + fileName;
        int len = filePath.lastIndexOf("/");
        // 检查文件路径是否合法
        if (StringUtils.isBlank(filePath) || len == -1) {
            return ResultVOUtil.error("未上传文件！");
        }
        // 检查文件是否存在
        File file = new File(filePath);
        if (!file.exists()) {
            return ResultVOUtil.error("文件不存在！");
        }
        // 对文件名进行URL编码，以处理包含非ASCII字符的文件名
        fileName = URLEncoder.encode(fileName, "UTF-8");
        try {
            // 设置响应头，强制浏览器以附件形式下载文件
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            response.setCharacterEncoding("UTF-8");
            // 获取响应输出流
            OutputStream out = response.getOutputStream();
            // 创建文件输入流
            BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
            try {
                // 读取文件内容并写入输出流
                byte[] content = new byte[1024];
                int length;
                while ((length = fin.read(content, 0, content.length)) != -1) {
                    out.write(content, 0, length);
                }
                // 下载成功
                return ResultVOUtil.success("文件下载成功");
            } catch (Exception e) {
                // 下载失败
                return ResultVOUtil.success("文件下载失败" + e.getMessage());
            } finally {
                // 关闭输入输出流
                fin.close();
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            // 记录错误日志
            loggerInfo.error(e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 批量删除附件信息
     *
     * @param fileId 文件ID
     * @return 返回删除结果
     */
    @ApiOperation(value = "批量删除附件信息", nickname = "deleteRelationFile", notes = "批量删除附件信息")
    @GetMapping("/deleteRelationFile/{fileId}")
    public ResultVO deleteRelationFile(@PathVariable("fileId") String fileId) {
        try {
            int i1 = 0;
            String[] fileSplit = fileId.split(",");
            for (int i = 0; i < fileSplit.length; i++) {
                String s = fileSplit[i];
                TrustRelationFileExample trustRelationFileExample = new TrustRelationFileExample();
                trustRelationFileExample.createCriteria().andFileIdEqualTo(s);
                i1 = trustRelationFileMapper.deleteByExample(trustRelationFileExample);
            }

            if (i1 > 0) {
                return ResultVOUtil.success();
            } else {
                return ResultVOUtil.error("失败");
            }
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.getStatus(), e.getMessage());
        } catch (Exception e) {
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    /**
     * 查询所有文件信息
     *
     * @param trustFile 文件查询条件
     * @return 返回文件查询结果，包括文件列表、页码、每页数量、总数量等信息
     */

    @ApiOperation(value = "查询所有文件信息", nickname = "selectFileAll", notes = "查询所有文件信息")
    @PostMapping("/selectFileAll")
    public ResultVO selectFileAll(TrustFile trustFile) {
        try {
            JSONObject returnPage = new JSONObject();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            TrustFileExample trustFileExample = new TrustFileExample();
            // 根据文件原名设置查询条件
            if (!"".equals(trustFile.getFileOriginName()) && trustFile.getFileOriginName() != null) {
                trustFileExample.createCriteria().andFileOriginNameEqualTo(trustFile.getFileOriginName());
            }
            // 设置分页查询的起始和结束位置
            trustFileExample.setStart((trustFile.getPage() - 1) * trustFile.getCount());
            trustFileExample.setEnd(trustFile.getCount());
            // 查询总数量
            Long count1 = trustFileMapper.count(trustFileExample);
            // 查询文件列表
            List<TrustFile> tlFiles = trustFileMapper.selectByExample(trustFileExample);
            // 构建返回的分页信息
            returnPage.put("totalCount", count1);
            returnPage.put("page", trustFile.getPage());
            returnPage.put("count", trustFile.getCount());
            returnMap.put("page", returnPage);
            returnMap.put("msg", "success");
            returnMap.put("data", tlFiles);
            return ResultVOUtil.success(returnMap);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }

    /**
     * 查询单个文件信息
     *
     * @param fileId 文件ID
     * @return 返回指定文件的详细信息
     */
    @ApiOperation(value = "查询单个文件信息", nickname = "selectFileById", notes = "查询单个文件信息")
    @GetMapping("/selectFileById/{fileId}")
    public ResultVO selectFileById(@PathVariable("fileId") Integer fileId) {
        try {
            TrustFile tlFile = trustFileMapper.selectByPrimaryKey(fileId);
            return ResultVOUtil.success(tlFile);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }

    /**
     * 判断图片信息（例如：是否包含皮肤检测等）
     *
     * @param file 需要处理的图片文件
     * @return 返回图片处理结果，包括是否包含皮肤等信息
     */
    @CrossOrigin(origins = "*")
    @PostMapping("/skinDetection")
    @ApiOperation(value = "判断图片信息", nickname = "skinDetection", notes = "判断图片信息")
    @ResponseBody
    public ResultVO skinDetection(@RequestParam("file") MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
        String fileName = file.getOriginalFilename();
        try {
            // 进行图片处理
            boolean skinDetected = FileService.processImage(file);
            returnMap.put("skin", skinDetected);
        } catch (IOException e) {
            returnMap.put(fileName, "处理文件异常");
        }
        return ResultVOUtil.success(returnMap);
    }

    /**
     * 获取伤口信息（通过上传的图片进行分析）
     *
     * @param files   需要分析的图片文件列表
     * @param request HTTP请求对象
     * @return 返回伤口分析结果
     * @throws Exception 异常
     */
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "获取伤口信息", nickname = "getWoundInformation", notes = "获取伤口信息")
    @ResponseBody
    @PostMapping(value = "/getWoundInformation", produces = "application/json;charset=utf-8")
    public ResultVO getWoundInformation(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        fileService.getWoundInformation(returnMap, files);
        /*上传图片到文件服务器并返回图片信息*/
        return ResultVOUtil.success(returnMap);
    }

    /**
     * 获取肤质详情（通过上传的图片进行分析）
     *
     * @param files   需要分析的图片文件列表
     * @param request HTTP请求对象
     * @return 返回肤质分析结果
     * @throws InterruptedException 异常
     */
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "获取肤质详情", nickname = "getSkinInfo", notes = "获取肤质详情")
    @ResponseBody
    @PostMapping(value = "/getSkinInfo", produces = "application/json;charset=utf-8")
    public ResultVO getSkinInfo(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request) throws InterruptedException {
        Map<String, Object> returnMap = new ConcurrentHashMap<>();
        // 初始化计数器，因为我们有两个任务
        CountDownLatch latch = new CountDownLatch(2);
        executorService.submit(() -> {
            try {
                ySkinService.getSkinInfo(returnMap, files);
            } catch (Exception e) {
                // 异常处理
                // 注意：根据实际情况决定是否需要处理异常后继续 countdown，或者直接抛出异常
            } finally {
                // 任务完成，递减计数器
                latch.countDown();
            }
        });
        executorService.submit(() -> {
            try {
                fileService.upload(returnMap, files);
            } catch (Exception e) {
                // 异常处理
                // 同上，根据情况处理异常
            } finally {
                // 任务完成，递减计数器
                latch.countDown();
            }
        });
        // 等待所有任务完成
        // 这里会阻塞直到countDown到0，即所有任务完成
        latch.await();
        // 所有任务完成后，安全地返回结果
        return ResultVOUtil.success(returnMap);
    }

    /**
     * 将excel数据保存到数据库
     *
     * @param files   excel文件内容
     * @param request HTTP请求对象
     * @return 返回保存结果
     * @throws IOException          异常
     * @throws NoSuchFieldException 异常
     * @throws ClientException      异常
     */
    @CrossOrigin(origins = "*")
    @ApiOperation(value = "将excel数据保存到数据库", nickname = "addExcel", notes = "将excel数据保存到数据库")
    @ResponseBody
    @PostMapping(value = "/addExcel", produces = "application/json;charset=utf-8")
    public ResultVO addExcel(String files, HttpServletRequest request) throws IOException, NoSuchFieldException, ClientException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        return fileService.addExcel(files);
    }

}

