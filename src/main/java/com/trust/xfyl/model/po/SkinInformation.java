package com.trust.xfyl.model.po;

import java.util.Date;

/**
 * TODO
 *
 * @author Bay-max
 * @Description
 * @date 2024/5/10 15:08
 **/

public class SkinInformation {
    private Integer id;

    private Integer userId;

    private String skinInfo;

    private Date createTime;

    private String isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSkinInfo() {
        return skinInfo;
    }

    public void setSkinInfo(String skinInfo) {
        this.skinInfo = skinInfo == null ? null : skinInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete == null ? null : isDelete.trim();
    }
}