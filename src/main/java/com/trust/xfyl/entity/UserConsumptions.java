package com.trust.xfyl.entity;

import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class UserConsumptions {
    private Integer consumptionId;

    private Integer userId;

    private Date consumptionTime;

    private Integer messageSentCount;

    private Integer purchaseId;

    private Date createTime;

    private Integer isDelete;

    public Integer getConsumptionId() {
        return consumptionId;
    }

    public void setConsumptionId(Integer consumptionId) {
        this.consumptionId = consumptionId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getConsumptionTime() {
        return consumptionTime;
    }

    public void setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
    }

    public Integer getMessageSentCount() {
        return messageSentCount;
    }

    public void setMessageSentCount(Integer messageSentCount) {
        this.messageSentCount = messageSentCount;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}