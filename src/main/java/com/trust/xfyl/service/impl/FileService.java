package com.trust.xfyl.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.trust.xfyl.dao.FoodSugarMapper;
import com.trust.xfyl.dao.TrustFileMapper;
import com.trust.xfyl.dao.TrustRelationFileMapper;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.FoodSugar;
import com.trust.xfyl.model.po.TrustFile;
import com.trust.xfyl.model.po.TrustRelationFile;
import com.trust.xfyl.util.ExcelImporterUtils;
import com.trust.xfyl.util.alibabaCloudTools.AliOSSClientUtils;
import com.trust.xfyl.util.alibabaCloudTools.AliSkinDetectorUtils;
import com.trust.xfyl.util.alibabaCloudTools.SkinDetection;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

import static com.trust.xfyl.util.alibabaCloudTools.AliSkinDetectorUtils.DF;

/**
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class FileService {
    private static String uploadImgUrl;
    private final TrustFileMapper trustFileMapper;
    private final FoodSugarMapper foodSugarMapper;

    private final TrustRelationFileMapper trustRelationFileMapper;
    String accessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
    String keySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");

    /**
     * FileService 构造函数
     * @param trustFileMapper 用于信任文件映射的mapper
     * @param trustRelationFileMapper 用于信任关系文件映射的mapper
     * @param foodSugarMapper 用于食品含糖映射的mapper
     */
    public FileService(TrustFileMapper trustFileMapper, TrustRelationFileMapper trustRelationFileMapper, FoodSugarMapper foodSugarMapper) {
        this.trustFileMapper = trustFileMapper;
        this.foodSugarMapper = foodSugarMapper;
        this.trustRelationFileMapper = trustRelationFileMapper;
    }

    /**
     * 处理图片上传和检测
     * @param multipartFile 上传的多部分文件
     * @return boolean 返回处理结果，true为成功，false为失败
     * @throws IOException 当文件处理或IO操作失败时抛出
     */
    public static boolean processImage(MultipartFile multipartFile) throws IOException {
        File tempFile = null;
        try {
            // 创建临时文件并把上传的文件内容转移到此临时文件
            tempFile = File.createTempFile("temp", null);
            multipartFile.transferTo(tempFile);
            String realPath = tempFile.getAbsolutePath();

            // 检查文件是否被其他进程占用，若未占用则进行皮肤检测
            if (!isFileInUse(tempFile)) {
                return SkinDetection.skinDetection(realPath);
            } else {
                System.out.println("文件正在被其他进程占用，无法处理。");
                return false;
            }
        } finally {
            // 最终删除临时文件
            if (tempFile != null) {
                Files.delete(tempFile.toPath());
            }
        }
    }

    /**
     * 检查文件是否被其他进程占用
     * @param file 需要检查的文件
     * @return boolean 如果文件被占用则返回true，否则返回false
     */
    private static boolean isFileInUse(File file) {
        try {
            // 尝试以读写方式打开文件，若成功则表示文件未被占用
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.close();
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 设置上传图片的URL前缀
     * @param uploadImgUrl 图片URL的前缀
     */
    @Value("${imageurl.uploadImgUrl}")
    public void setUploadImgUrl(String uploadImgUrl) {
        FileService.uploadImgUrl = uploadImgUrl;
    }

    /**
     * 上传文件并保存到数据库
     * @param returnMap 用于返回上传结果的Map
     * @param files 上传的文件列表
     * @throws IOException 当文件处理或IO操作失败时抛出
     * @throws NoSuchFieldException 当查找字段失败时抛出
     * @throws ClientException 当客户端操作失败时抛出
     */
    public void upload(Map<String, Object> returnMap, List<MultipartFile> files) throws IOException, NoSuchFieldException, ClientException {
        List<TrustFile> trustFiles = new ArrayList<>();
        // 调用方法上传文件并获取上传后的文件信息列表
        ResultVO resultVO = AliOSSClientUtils.uploadFiles(files);
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) resultVO.getData();
        Object fileName = null;
        Object fileUrl = null;
        Object originalFilename = null;
        for (Map<String, Object> fileMap : dataList) {
            // 遍历文件信息，创建TrustFile对象
            fileName = fileMap.get("fileName");
            fileUrl = fileMap.get("fileUrl");
            originalFilename = fileMap.get("originalFilename");
            TrustFile trustFile = new TrustFile();
            trustFile.setIsDelete(0);
            trustFile.setCreateTime(new Date());
            trustFile.setFileName(fileName.toString());
            trustFile.setFileOriginName(originalFilename.toString());
            trustFile.setFileUrl((String) fileUrl);
            trustFiles.add(trustFile);
        }
        if (dataList.size() > 0) {
            // 批量插入文件信息到数据库
            List<TrustFile> afterInsertFile = addImg(trustFiles);
            System.out.println("插入成功");
            // 组装返回信息
            returnMap.put("fileName", fileName);
            returnMap.put("fileUrl", fileUrl);
            returnMap.put("originalFilename", originalFilename);
            returnMap.put("status", 0);
            returnMap.put("msg", "上传成功");
        } else {
            // 组装上传失败的返回信息
            returnMap.put("status", -1);
            returnMap.put("msg", "上传失败");
            System.out.println("上传失败");
        }
    }

    /**
     * 获取伤口信息
     * @param returnMap 用于返回结果的Map，包含状态、消息和伤口信息列表
     * @param files 需要上传的文件列表
     * @return ResultVO 返回操作的结果，其中包含成功或失败的状态以及相应的消息
     * @throws Exception 处理过程中可能抛出的异常
     */
    public ResultVO getWoundInformation(Map<String, Object> returnMap, List<MultipartFile> files) throws Exception {
        // 上传文件
        ResultVO resultVO = AliOSSClientUtils.uploadFiles(files);
        // 注释掉的代码是下载文件的逻辑，当前不使用
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) resultVO.getData();
        // 检查文件是否上传成功
        if (dataList.isEmpty()) {
            return ResultVOUtil.error(-1, "文件上传失败");
        }

        // 将上传后的文件信息转换为TrustFile对象列表
        List<TrustFile> trustFiles = dataList.stream().map(customClass -> {
            TrustFile trustFile = new TrustFile();
            trustFile.setIsDelete(0);
            trustFile.setCreateTime(new Date());
            trustFile.setFileName((String) customClass.get("fileName"));
            trustFile.setFileOriginName((String) customClass.get("originalFilename"));
            trustFile.setFileUrl((String) customClass.get("fileUrl"));
            return trustFile;
        }).collect(Collectors.toList());

        // 将TrustFile对象列表插入数据库
        List<TrustFile> afterInsertFile = addImg(trustFiles);

        // 检查数据是否插入成功
        if (afterInsertFile.isEmpty()) {
            return ResultVOUtil.error(-1, "数据插入异常");
        }

        try {
            List<List<String>> woundInformationLists = new ArrayList<>();
            // 设置时区
            DF.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
            for (TrustFile trustFile : afterInsertFile) {
                // 调用阿里云皮肤检测API
                String fileUrl = trustFile.getFileUrl();
                JSONObject skinDetectionResult = AliSkinDetectorUtils.execute("DetectSkinDisease", accessKeyId, keySecret, Collections.singletonMap("Url", fileUrl)).getJSONObject("Data");
                JSONObject resultsObject = skinDetectionResult.getJSONObject("Results");
                // 解析API返回的结果，找到可能性最大的皮肤问题
                double maxProbability = 0.0;
                String maxParameter = "";
                for (String key : resultsObject.keySet()) {
                    double value = resultsObject.getDouble(key);
                    if (value > maxProbability) {
                        maxProbability = value;
                        maxParameter = key;
                    }
                }
                // 收集伤口信息
                System.out.println("最大概率参数为：" + maxParameter + "，概率值为：" + maxProbability);
                String bodyPart = skinDetectionResult.getString("BodyPart");
                List<String> woundInformationList = new ArrayList<>();
                woundInformationList.add("皮肤问题的可能性:" + maxParameter + ": " + maxProbability);
                woundInformationList.add("皮肤检测部位:" + bodyPart);
                woundInformationLists.add(woundInformationList);
            }

            // 将伤口信息和状态消息添加到returnMap中
            returnMap.put("woundInformationList", woundInformationLists);
            returnMap.put("status", 0);
            returnMap.put("msg", "上传成功");
            return ResultVOUtil.success(returnMap);
        } catch (Exception e) {
            // 处理异常，返回错误信息
            returnMap.put("status", -1);
            returnMap.put("msg", e.getMessage());
            e.printStackTrace();
            return ResultVOUtil.error(-1, e.getMessage());
        }
    }


    /**
     * 将TrustFile对象列表插入数据库
     * @param trustFiles 需要插入的TrustFile对象列表
     * @return 返回插入的文件列表
     */
    /**
     * 将图片信息添加到数据库。
     *
     * @param trustFiles 包含图片信息的列表。
     * @return 返回添加图片信息的列表。
     */
    private List<TrustFile> addImg(List<TrustFile> trustFiles) {
        // 插入数据到数据库
        int i = trustFileMapper.afterInsertFile(trustFiles);
        return trustFiles;
    }

    /**
     * 添加文件关系到数据库。
     *
     * @param trustRelationFile 包含文件关系信息的对象。
     * @return 如果所有文件关系都成功添加，返回true；否则返回false。
     */
    public boolean addFileRela(TrustRelationFile trustRelationFile) {
        String[] fileids = trustRelationFile.getFileId().split(",");
        int insertResult = 0;
        for (String fileid : fileids) {
            TrustRelationFile trustRelationFile1 = new TrustRelationFile();
            trustRelationFile1.setBusiId(trustRelationFile.getBusiId());
            trustRelationFile1.setBusiType(trustRelationFile.getBusiType());
            trustRelationFile1.setPhotoType(trustRelationFile.getPhotoType());
            trustRelationFile1.setFileId(fileid);
            insertResult += trustRelationFileMapper.insertSelective(trustRelationFile1);
        }
        // 检查是否所有文件关系都成功插入
        return fileids.length == insertResult;
    }

    /**
     * 从Excel文件添加数据到数据库。
     *
     * @param filePath Excel文件的路径。
     * @return 如果数据添加成功，返回成功信息；否则返回失败信息。
     */
    public ResultVO addExcel(String filePath) {
        List<FoodSugar> foodSugars = ExcelImporterUtils.importData(filePath);
        int i1 = 0;
        // 循环插入从Excel导入的数据
        for (int i = 0; i < foodSugars.size(); i++) {
            FoodSugar foodSugar = foodSugars.get(i);
            i1 = foodSugarMapper.insertSelective(foodSugar);
        }
        // 根据插入结果返回成功或失败的信息
        if (i1 > 0) {
            return ResultVOUtil.success("成功");
        } else {
            return ResultVOUtil.error("失败");
        }

    }

}
