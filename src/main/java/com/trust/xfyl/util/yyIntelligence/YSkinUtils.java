package com.trust.xfyl.util.yyIntelligence;

import com.trust.xfyl.dao.SkinInformationMapper;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.model.po.SkinInformation;
import com.trust.xfyl.service.impl.FileService;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 * @author big-max
 * @title YSkin 宜远智能的api调用
 * @date 2024/5/8 16:59
 * @description 提供与宜远智能API交互的功能，主要实现文件上传。
 */
@Component
public class YSkinUtils {

    private static final String BOUNDARY = "----WebKitFormBoundary" + UUID.randomUUID().toString().substring(0, 8);
    private static final String CLIENT_ID = "52fdebffa0e84a09";
    private static final String CLIENT_SECRET = "59cf8271bf7a71f76b61c2914b6ffa46";
    private static final int BUFFER_SIZE = 4096;
    private final SkinInformationMapper skinInformationMapper;
    /**
     * YSkin 构造函数
     *
     * @param skinInformationMapper 皮肤信息映射器，用于数据库操作
     */
    public YSkinUtils(SkinInformationMapper skinInformationMapper, FileService fileService) {
        this.skinInformationMapper = skinInformationMapper;
    }
    /**
     * 通用的文件上传方法，通过传入API URL和文件列表来完成上传。
     *
     * @param apiUrl API的URL
     * @param files  文件列表
     * @return ResultVO 上传结果，包含上传成功与否的信息及响应内容
     * @throws IOException 读取文件或发送请求时可能抛出的异常
     */
    public ResultVO uploadFiles(String apiUrl, List<MultipartFile> files) throws IOException, NoSuchFieldException {
        // 检查文件列表是否为空
        if (files == null || files.isEmpty()) {
            throw new IllegalArgumentException("文件列表不能为空");
        }
        Map<String, Object> returnMap = new HashMap<>();
        // 编码认证信息
        String encodedAuth = Base64.getEncoder().encodeToString((CLIENT_ID + ":" + CLIENT_SECRET).getBytes());
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", "Basic " + encodedAuth);
        connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
        // 构建请求体
        try (OutputStream output = connection.getOutputStream();
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8), true)) {
            for (MultipartFile file : files) {
                // 写入文件的表单信息
                writer.append("--").append(BOUNDARY).append("\r\n")
                        .append("Content-Disposition: form-data; name=\"image\"; filename=\"").append(file.getName()).append("\"\r\n")
                        .append("Content-Type: image/JPEG\r\n\r\n");
                writer.flush();
                // 写入文件数据
                try (InputStream fileInputStream = file.getInputStream()) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;
                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                }
                output.flush(); // 确保数据写入
                writer.append("\r\n--").append(BOUNDARY).append("--\r\n");
            }
            writer.flush();
        }
        // 处理响应
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code : " + responseCode);
        try (InputStream inputStream = connection.getInputStream();
             InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            StringBuilder resultBuffer = new StringBuilder();
            String tempLine;
            // 读取响应内容
            while ((tempLine = bufferedReader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            System.out.println(resultBuffer);
            returnMap.put("resultBuffer", resultBuffer.toString());
            // 处理业务逻辑：保存皮肤信息
            SkinInformation skinInformation = new SkinInformation();
            skinInformation.setCreateTime(new Date());
            skinInformation.setIsDelete("0");
            skinInformation.setSkinInfo(resultBuffer.toString());
            skinInformationMapper.insertSelective(skinInformation);
            // 返回上传结果
            return ResultVOUtil.success(returnMap);
        } catch (IOException e) {
            // 处理上传失败的异常
            e.printStackTrace();
            return ResultVOUtil.error(500, "文件上传失败：" + e.getMessage());
        }
    }

}
