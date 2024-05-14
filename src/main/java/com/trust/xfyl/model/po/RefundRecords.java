package com.trust.xfyl.model.po;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class RefundRecords {
    private Integer refundId;

    private Integer userId;

    private Integer purchaseId;

    private String refundStatus;

    private Date refundRequestTime;

    private Date refundApprovalTime;

    private BigDecimal refundedAmount;

    private Boolean adminContacted;

    private Date createTime;

    private Integer isDelete;

    private String refundReason;

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public Date getRefundRequestTime() {
        return refundRequestTime;
    }

    public void setRefundRequestTime(Date refundRequestTime) {
        this.refundRequestTime = refundRequestTime;
    }

    public Date getRefundApprovalTime() {
        return refundApprovalTime;
    }

    public void setRefundApprovalTime(Date refundApprovalTime) {
        this.refundApprovalTime = refundApprovalTime;
    }

    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public Boolean getAdminContacted() {
        return adminContacted;
    }

    public void setAdminContacted(Boolean adminContacted) {
        this.adminContacted = adminContacted;
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

    public String getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(String refundReason) {
        this.refundReason = refundReason == null ? null : refundReason.trim();
    }
}