package com.trust.xfyl.controller;

import com.aliyun.imageprocess20200320.models.RunMedQARequest;
import com.aliyun.imageprocess20200320.models.RunMedQAResponseBody;
import com.trust.xfyl.entity.ResultVO;
import com.trust.xfyl.entity.dto.SampleDto;
import com.trust.xfyl.util.ResultVOUtil;
import com.trust.xfyl.util.Sample;
import com.trust.xfyl.util.StsServiceSample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @Description
 * @Author Bay-max
 * @Date 2024/3/15 15:58
 **/
@RequestMapping("/medical")
@RestController
public class MedicalQuestionAnswerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalQuestionAnswerController.class);

    /**
     * 初始化会话并上传答案图片。
     *
     * @param answerImageFile 包含答案图片的MultipartFile列表。
     * @throws Exception 如果上传文件时出现问题，可能会抛出异常。
     * @return
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @PostMapping(value = "/up")
    private ResultVO initializeSession(@RequestParam("answerImageFile") List<MultipartFile> answerImageFile) throws Exception {
        SampleDto initialSampleDto = new SampleDto();
        // 设置问题类型为图片
        initialSampleDto.setQuestionType("images");
        // 调用文件上传服务，上传答案图片
        ResultVO resultVO = StsServiceSample.uploadFiles(answerImageFile);
        // 解析上传服务返回的结果，获取图片的URL列表
        List<Map<String, Object>> dataList = (List<Map<String, Object>>) resultVO.getData();
        List<RunMedQARequest.RunMedQARequestAnswerImageURLList> answerImageList = new ArrayList<>();
        for (Map<String, Object> fileMap : dataList) {
            // 获取单个图片的URL
            String fileUrl = (String) fileMap.get("fileUrl");
            RunMedQARequest.RunMedQARequestAnswerImageURLList urlList = new RunMedQARequest.RunMedQARequestAnswerImageURLList();
            // 设置图片URL
            urlList.setAnswerImageURL(fileUrl);
            // 将图片URL添加到列表
            answerImageList.add(urlList);
        }
        // 将答案图片URL列表设置到SampleDto对象中
        initialSampleDto.setAnswerImageList(answerImageList);
        RunMedQAResponseBody.RunMedQAResponseBodyData responseData = Sample.executeMedicalQuestionAndAnswer(initialSampleDto);
        return ResultVOUtil.success(responseData);

    }

    /**
     * 处理医疗问题的请求。
     * @param {String} initialSampleDto
     * @return 返回一个响应实体，包含阿里云接口调用的响应数据。
     * @throws Exception 如果传入的sampleDto中会话ID非空但答案文本为空，则抛出IllegalArgumentException异常。
     */
    @CrossOrigin(origins = "*")
    @ResponseBody
    @PostMapping(value = "/qa")
    public ResponseEntity<RunMedQAResponseBody.RunMedQAResponseBodyData> processMedicalQuestion(@RequestBody SampleDto sampleDto) throws Exception{
        // 根据会话ID判断是初始化新会话还是继续现有会话
        if (sampleDto.getSessionId() == null) {
            throw new IllegalArgumentException("sessionId must be provided for continuing a session");
        }
        // 已有会话继续进行，同时检查answerText是否为空
        if (sampleDto.getAnswerText() == null && !"images".equals(sampleDto.getQuestionType())) {
            throw new IllegalArgumentException("answerText must not be empty when sessionId is provided and the question type is not 'images'");
        }
        // 执行医疗问题解答流程，并返回结果
        RunMedQAResponseBody.RunMedQAResponseBodyData responseData = Sample.executeMedicalQuestionAndAnswer(sampleDto);
        System.out.println(responseData);
        return ResponseEntity.ok(responseData);
    }

}