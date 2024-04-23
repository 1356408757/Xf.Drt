package com.trust.xfyl.controller;

import com.aliyuncs.exceptions.ClientException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.entity.TrustFile;
import com.trust.xfyl.entity.TrustFileExample;
import com.trust.xfyl.entity.TrustRelationFileExample;
import com.trust.xfyl.exception.SCServiceException;
import com.trust.xfyl.service.FileService;
import com.trust.xfyl.util.ResultVOUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

/**
 * @author Bay-max
 * @date 2024/4/22 15:14
 **/

@RestController
@Api(value = "文件上传，下载", description = "文件上传，下载", tags = "文件上传，下载")
@RequestMapping("/uploaFile")
public class FileController {
    private static final Logger loggerInfo = null;
    private static String uploadImgUrl;
    private final FileService fileService;
    private final TrustRelationFileMapper trustRelationFileMapper;
    private final TrustFileMapper trustFileMapper;

    public FileController(FileService fileService, TrustRelationFileMapper trustRelationFileMapper, TrustFileMapper trustFileMapper) {
        this.fileService = fileService;
        this.trustRelationFileMapper = trustRelationFileMapper;
        this.trustFileMapper = trustFileMapper;
    }

    @Value("${imageurl.uploadImgUrl}")
    public void setUploadImgUrl(String uploadImgUrl) {
        FileController.uploadImgUrl = uploadImgUrl;
    }


    /**
     * @return java.lang.String
     * @Author djj
     * @Description //TODO
     * @Date 15:57 2024/1/25
     * @Param [file, request]
     **/
    @CrossOrigin(origins = "*")
    @PostMapping
    @ApiOperation(value = "新增文件信息", nickname = "addFile", notes = "新增文件信息")
    @ResponseBody
    @RequestMapping(value = "/addFile", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String addFile(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request) throws IOException, NoSuchFieldException, ClientException {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        fileService.upload(returnMap, files);
        /*上传图片到文件服务器并返回图片信息*/
        return mapper.writeValueAsString(returnMap);
    }


    @PostMapping
    @ApiOperation(value = "下载文件信息", nickname = "download", notes = "下载文件信息")
    @ResponseBody
    @RequestMapping(value = "/download")
    public ResultVO downLoad(String fileName, HttpServletResponse response) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        String filePath = uploadImgUrl + "/" + fileName;
        int len = filePath.lastIndexOf("/");
        if (StringUtils.isBlank(filePath) || len == -1) {
            return ResultVOUtil.error("未上传文件！");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return ResultVOUtil.error("文件不存在！");
        }
        fileName = URLEncoder.encode(fileName, "UTF-8");
        try {
            response.setHeader("Content-disposition", "attachment; filename=" + fileName);
            response.setCharacterEncoding("UTF-8");
            OutputStream out = response.getOutputStream();
            BufferedInputStream fin = new BufferedInputStream(new FileInputStream(file));
            try {
                byte[] content = new byte[1024];
                int length;
                while ((length = fin.read(content, 0, content.length)) != -1) {
                    out.write(content, 0, length);
                }
                return ResultVOUtil.success("文件下载成功");
            } catch (Exception e) {
                return ResultVOUtil.success("文件下载失败" + e.getMessage());
            } finally {
                fin.close();
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            loggerInfo.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping
    @ApiOperation(value = "批量删除附件信息", nickname = "deleteRelationFile", notes = "批量删除附件信息")
    @RequestMapping("/deleteRelationFile/{fileId}")
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

    @GetMapping
    @ApiOperation(value = "查询所有文件信息", nickname = "selectFileAll", notes = "查询所有文件信息")
    @RequestMapping("/selectFileAll")
    public ResultVO selectFileAll(TrustFile trustFile) {
        try {
            JSONObject returnPage = new JSONObject();
            Map<String, Object> returnMap = new HashMap<String, Object>();
            TrustFileExample trustFileExample = new TrustFileExample();
            if (!"".equals(trustFile.getFileOriginName()) && trustFile.getFileOriginName() != null) {
                trustFileExample.createCriteria().andFileOriginNameEqualTo(trustFile.getFileOriginName());
            }
            trustFileExample.setStart((trustFile.getPage() - 1) * trustFile.getCount());
            trustFileExample.setEnd(trustFile.getCount());
            Long count1 = trustFileMapper.count(trustFileExample);
            List<TrustFile> tlFiles = trustFileMapper.selectByExample(trustFileExample);
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

    @GetMapping
    @ApiOperation(value = "查询单个文件信息", nickname = "selectFileById", notes = "查询单个文件信息")
    @RequestMapping("/selectFileById/{fileId}")
    public ResultVO selectFileById(@PathVariable("fileId") Integer fileId) {
        try {
            TrustFile tlFile = trustFileMapper.selectByPrimaryKey(fileId);
            return ResultVOUtil.success(tlFile);
        } catch (SCServiceException e) {
            return ResultVOUtil.error(e.toString());
        }
    }
    /**
     * @return java.lang.String
     * @Author djj
     * @Description //TODO
     * @Date 15:57 2024/1/25
     * @Param [file, request]
     **/
    @CrossOrigin(origins = "*")
    @PostMapping("/skinDetection")
    @ApiOperation(value = "判断图片信息", nickname = "skinDetection", notes = "判断图片信息")
    @ResponseBody
    public ResultVO skinDetection(@RequestParam("file")MultipartFile file) {
        Map<String, Object> returnMap = new HashMap<>();
            String fileName = file.getOriginalFilename();
            try {
                boolean skinDetected =FileService.processImage(file);
                returnMap.put("skin",skinDetected);
            } catch (IOException e) {
                returnMap.put(fileName, "处理文件异常");
            }
        return ResultVOUtil.success(returnMap);
    }



    /**
     * @return java.lang.String
     * @Author djj
     * @Description //TODO
     * @Date 15:57 2024/1/25
     * @Param [file, request]
     **/
    @CrossOrigin(origins = "*")
    @PostMapping
    @ApiOperation(value = "获取伤口信息", nickname = "getWoundInformation", notes = "获取伤口信息")
    @ResponseBody
    @RequestMapping(value = "/getWoundInformation", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public ResultVO getWoundInformation(@RequestParam("files") List<MultipartFile> files, HttpServletRequest request) throws Exception {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        fileService.getWoundInformation(returnMap, files);
        /*上传图片到文件服务器并返回图片信息*/
        return ResultVOUtil.success(returnMap);
    }
}

