package com.trust.xfyl.enums;

/**
 * 错误代码枚举类，用于定义系统中可能出现的错误代码及其对应的信息。
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public enum ErrorCodeEnum {
    /**
     * 系统错误
     */
    SYSTEM_ERROR("10000", "System error"),

    /**
     * 请求参数无效
     */
    PARAMS_INVALID("10001", "Request param is missing"),

    /**
     * 请求LLM超时
     */
    REQUEST_LLM_TIMEOUT("10100", "Request LLM timout"),

    /**
     * 客户端用户不存在
     */
    GUEST_NOT_EXIST("10201", "Guest user does not exist"),

    /**
     * 创建完成错误
     */
    CREATE_COMPLETION_ERROR("10301", "create completion error"),
    ;

    /**
     * 错误代码
     */
    private final String errorCode;

    /**
     * 错误消息
     */
    private final String errorMessage;

    /**
     * 构造函数，用于初始化错误代码和错误消息。
     * @param errorCode 错误代码
     * @param errorMessage 错误消息
     */
    ErrorCodeEnum(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * 根据错误代码获取错误代码枚举实例。
     * @param errorCode 错误代码
     * @return 匹配的错误代码枚举实例，如果找不到则返回SYSTEM_ERROR
     */
    public static ErrorCodeEnum getErrorCodeEnum(String errorCode) {
        for (ErrorCodeEnum codeConstants : values()) {
            if (codeConstants.errorCode.equals(errorCode)) {
                return codeConstants;
            }
        }
        return SYSTEM_ERROR;
    }

    /**
     * 获取错误代码。
     * @return 错误代码字符串
     */
    public String getErrorCode() {
        return this.errorCode;
    }

    /**
     * 获取错误消息。
     * @return 错误消息字符串
     */
    public String getErrorMessage() {
        return this.errorMessage;
    }

    /**
     * 获取格式化后的错误消息。
     * @param args 错误消息中的参数
     * @return 格式化后的错误消息字符串
     */
    public String getErrorMessage(Object... args) {
        return String.format(this.errorMessage, args);
    }
}
