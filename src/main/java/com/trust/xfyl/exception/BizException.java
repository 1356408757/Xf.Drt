package com.trust.xfyl.exception;

import com.trust.xfyl.enums.ErrorCodeEnum;

/**
 * 业务异常类，用于处理业务逻辑中发生的异常情况。
 * 继承自RuntimeException，可抛出运行时异常。
 *
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/

public class BizException extends RuntimeException {
    // 错误码，用于标识异常的类型
    private String errorCode;

    /**
     * 构造函数，初始化错误码和错误信息。
     *
     * @param errorCode 错误码，用于标识具体的异常类型。
     * @param message   错误信息，描述异常的具体情况。
     */
    public BizException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * 构造函数，通过ErrorCodeEnum枚举初始化错误码和错误信息。
     *
     * @param errorCode 错误码枚举，包含错误码和错误信息。
     */
    public BizException(ErrorCodeEnum errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode.getErrorCode();
    }

    /**
     * 带有导致异常的原因的构造函数。
     *
     * @param errorCode 错误码，用于标识具体的异常类型。
     * @param message   错误信息，描述异常的具体情况。
     * @param cause     导致异常的原因。
     */
    public BizException(String errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    /**
     * 通过ErrorCodeEnum枚举和导致异常的原因初始化错误码和错误信息。
     *
     * @param errorCode 错误码枚举，包含错误码和错误信息。
     * @param cause     导致异常的原因。
     */
    public BizException(ErrorCodeEnum errorCode, Throwable cause) {
        super(errorCode.getErrorMessage(), cause);
        this.errorCode = errorCode.getErrorCode();
    }

    /**
     * Java 7 引入的构造函数，提供更复杂的异常处理支持。
     *
     * @param errorCode          错误码，用于标识具体的异常类型。
     * @param message            错误信息，描述异常的具体情况。
     * @param cause              导致异常的原因。
     * @param enableSuppression  是否允许抑制异常。
     * @param writableStackTrace 是否允许错误栈信息可写。
     */
    public BizException(String errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
    }

    /**
     * 带有复杂异常处理选项的构造函数，通过ErrorCodeEnum枚举初始化。
     *
     * @param errorCode          错误码枚举，包含错误码和错误信息。
     * @param cause              导致异常的原因。
     * @param enableSuppression  是否允许抑制异常。
     * @param writableStackTrace 是否允许错误栈信息可写。
     */
    public BizException(ErrorCodeEnum errorCode, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode.getErrorMessage(), cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode.getErrorCode();
    }

    /**
     * 获取错误码。
     *
     * @return 错误码字符串。
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 设置错误码。
     *
     * @param errorCode 错误码。
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * 重写toString方法，返回错误码和错误信息的字符串表示。
     *
     * @return 描述异常的字符串。
     */
    @Override
    public String toString() {
        return "BizException{" + "errorCode=" + errorCode + ", " +
                "message=" + getMessage() +
                '}';
    }
}
