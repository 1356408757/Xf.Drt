package com.trust.xfyl.enums;

/**
 * 结果状态码枚举类
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public enum ResultEnum {

    // 成功状态码
    SUCCESS(0, "success"),
    // 失败状态码
    FAIL(-1, "fail"),
    // 内部服务器错误状态码
    INTERNAL_SERVER_ERROR(1, "内部服务器错误");

    private Integer status; // 状态码
    private String message; // 相应信息

    /**
     * 构造方法，初始化状态码和信息
     * @param status 状态码
     * @param message 相应信息
     */
    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    // 默认构造方法，用于枚举类型的内部机制
    ResultEnum() {
    }

    /**
     * 获取状态码
     * @return 状态码
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态码
     * @param status 新的状态码
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取相应信息
     * @return 相应信息
     */
    public String getMessage() {
        return message;
    }

    /**
     * 设置相应信息
     * @param message 新的相应信息
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 根据状态码返回对应的枚举值
     * @param status 状态码
     * @return 对应的枚举值，如果找不到则返回null
     */
    public ResultEnum getResultEnumByStatus(Integer status) {
        for (ResultEnum resultEnum : ResultEnum.values()) {
            if (resultEnum.status.intValue() == status.intValue()) {
                return resultEnum;
            }
        }
        return null;
    }
}
