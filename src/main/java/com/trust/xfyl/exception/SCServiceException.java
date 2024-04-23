package com.trust.xfyl.exception;


import com.trust.xfyl.enums.ResultEnum;


/**
 * @author Bay-max
 * @date 2024/4/22 15:37
 **/
public class SCServiceException extends RuntimeException {
    private Integer status;

    public SCServiceException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.status = status;
    }

    public SCServiceException(Integer status, String message) {
        super(message);
        this.status = status;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
