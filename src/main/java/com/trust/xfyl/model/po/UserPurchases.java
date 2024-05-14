package com.trust.xfyl.model.po;

import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class UserPurchases {
    private Integer purchaseId;

    private Integer userId;

    private Integer packageId;

    private Date purchaseTime;

    private Integer creditCountPurchased;

    private String transactionId;

    private String paymentStatus;

    private Date createTime;

    private Integer isDelete;

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public Integer getCreditCountPurchased() {
        return creditCountPurchased;
    }

    public void setCreditCountPurchased(Integer creditCountPurchased) {
        this.creditCountPurchased = creditCountPurchased;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId == null ? null : transactionId.trim();
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus == null ? null : paymentStatus.trim();
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