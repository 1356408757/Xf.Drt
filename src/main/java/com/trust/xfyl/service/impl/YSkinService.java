package com.trust.xfyl.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.trust.xfyl.model.ResultVO;
import com.trust.xfyl.model.ResultVOUtil;
import com.trust.xfyl.util.yyIntelligence.YSkinUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 皮肤服务类，提供关于皮肤信息获取的功能。
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class YSkinService {
    private final YSkinUtils ySkinUtils;

    /**
     * YSkinService构造函数。
     * @param ySkinUtils 依赖注入的YSkin实例，用于文件上传操作。
     */
    public YSkinService(YSkinUtils ySkinUtils) {
        this.ySkinUtils = ySkinUtils;
    }

    /**
     * 获取皮肤信息的函数。
     * 该方法通过上传文件到特定API，来获取皮肤相关的分析信息。
     *
     * @param returnMap 用于存放返回结果的Map，其中会包含API返回的数据。
     * @param files 需要上传的文件列表，不能为空。
     * @return ResultVO 包含操作结果和数据的VO对象。
     * @throws ClientException 如果文件为空、文件大小超过限制、API调用失败、上传过程中发生IO异常或其他未知异常时，抛出ClientException。
     */
    public ResultVO getSkinInfo(Map<String, Object> returnMap, List<MultipartFile> files) throws ClientException {
        // 参数验证
        if (files == null || files.isEmpty()) {
            throw new IllegalArgumentException("文件列表不能为空");
        }

        // 进行文件大小和类型的校验，这里仅示意，具体实现根据需求定义
        for (MultipartFile file : files) {
            // 文件大小检查
            long size = file.getSize();
            // 假设10MB为最大上传文件大小
            if (size > 30485760) {
                throw new IllegalArgumentException("文件大小超过限制");
            }
        }

        ResultVO resultVO;
        try {
            // 调用YSkin的uploadFiles方法上传文件并获取结果
            resultVO = ySkinUtils.uploadFiles("https://api.yimei.ai/v2/api/face/analysis/17180112783", files);
            // 检查API调用结果是否成功
            if (!resultVO.getStatus().equals(0)) {
                // 根据实际情况处理失败情况，这里简单抛出异常
                throw new ClientException("API调用失败: " + resultVO.getMsg());
            }
        } catch (IOException e) {
            // 捕获并处理IOException，转化为ClientException
            throw new ClientException("文件上传过程中发生IO异常", e.getMessage());
        } catch (Exception e) {
            // 捕获并处理其他可能的异常
            throw new ClientException("文件上传过程中发生未知异常", e.getMessage());
        }
        // 将API返回的数据存入returnMap，并返回带有成功标识的结果VO
        returnMap.put("result", resultVO.getData());
        return ResultVOUtil.success(returnMap);
    }


}
