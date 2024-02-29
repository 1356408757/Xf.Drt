package com.trust.xfyl.exception;


import com.trust.xfyl.enums.ResultEnum;


/**
* @Author djj
* @Description //TODO
* @Date 16:01 2024/1/25
* @Param
* @return
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
