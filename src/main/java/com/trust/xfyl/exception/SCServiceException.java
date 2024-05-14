package com.trust.xfyl.exception;

import com.trust.xfyl.enums.ResultEnum;

/**
 * 自定义服务层异常类，用于处理服务层异常。
 * 请在适当场合使用该异常，确保对状态码和消息的正确处理。
 *
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
public class SCServiceException extends RuntimeException {
    private Integer status; // 异常状态码

    /**
     * 构造函数，根据ResultEnum枚举初始化异常。
     * 确保ResultEnum不为空。
     *
     * @param resultEnum 结果枚举，包含异常状态码和异常信息
     */
    public SCServiceException(ResultEnum resultEnum) {
        super(resultEnum != null ? resultEnum.getMessage() : "ResultEnum is null");
        if (resultEnum != null) {
            this.status = resultEnum.getStatus();
        } else {
            this.status = null; // 或设置为默认状态码
        }
    }

    /**
     * 构造函数，根据状态码和自定义信息初始化异常。
     * 确保状态码和消息不为空。
     *
     * @param status 异常状态码
     * @param message 异常信息
     */
    public SCServiceException(Integer status, String message) {
        super(message != null ? message : "Message is null");
        if (status != null) {
            this.status = status;
        } else {
            this.status = null; // 或设置为默认状态码
        }
    }

    /**
     * 获取异常状态码。
     *
     * @return 异常状态码
     */
    public Integer getStatus() {
        return status;
    }

    // 移除了setStatus方法，因为异常的状态码应当在构造时设定且不应变动。

    /**
     * 获取异常详细信息，包括状态码和消息。
     * 适当时机记录日志，便于异常追踪。
     *
     * @return 异常的详细信息
     */
    @Override
    public String getMessage() {
        String message = super.getMessage() != null ? super.getMessage() : "No message provided";
        if (status != null) {
            message += ". Status: " + status;
        }
        // 记录日志的示例代码，需要根据实际使用的日志框架进行调整
        // Logger.error(message);
        return message;
    }
}
