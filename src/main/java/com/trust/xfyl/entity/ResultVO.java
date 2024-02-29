package com.trust.xfyl.entity;

import java.io.Serializable;

/**
 * @author LENOVO
 */
public class ResultVO<T> implements Serializable {
    private static final long serialVersionUID = -2121347051998174679L;

    /**
     * 返回状态值
     */
    private Integer status;
    /**
     * 返回状态信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
