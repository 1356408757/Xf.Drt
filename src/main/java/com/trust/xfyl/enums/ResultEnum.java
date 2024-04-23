package com.trust.xfyl.enums;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/

public enum ResultEnum {


    SUCCESS(0, "success"),
    FAIL(-1, "fail"),
    INTERNAL_SERVER_ERROR(1, "内部服务器错误");

    private Integer status;
    private String message;

    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    ResultEnum() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 返回枚举值根据状态
     *
     * @param status
     * @return
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
