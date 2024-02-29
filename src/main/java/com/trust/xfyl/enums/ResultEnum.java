package com.trust.xfyl.enums;

/**
 * @author LENOVO
 */

public enum ResultEnum {


    SUCCESS(0, "success"),
    FAIL(-1, "fail");

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
