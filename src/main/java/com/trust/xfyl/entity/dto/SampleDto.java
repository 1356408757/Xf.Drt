package com.trust.xfyl.entity.dto;

import com.aliyun.imageprocess20200320.models.RunMedQARequest;
import lombok.Data;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/

@Data
@ToString
public class SampleDto {
    private String questionType;
    private String sessionId;
    private String answerText;
    private List<RunMedQARequest.RunMedQARequestAnswerImageURLList> answerImageList;
    private List<MultipartFile> answerImageUrl;

}
