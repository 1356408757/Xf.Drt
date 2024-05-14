package com.trust.xfyl.model.po;

import com.trust.xfyl.model.BaseBean;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class WoundOrders extends BaseBean {
    private Long id;

    private String orderNumber;

    private Long taskId;

    private Long doctorId;

    private String ordType;

    private BigDecimal orderPrice;

    private String business;

    private String medicalNumber;

    private String appointmentType;

    private String orderType;

    private String surgeryName;

    private String perioperativeSurgery;

    private Date surgeryTime;

    private String woundPhotoIds;

    private Date woundPhotographyTime;

    private String takingLens;

    private String woundCondition;

    private String isConfirm;

    private String isReservation;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    private Integer isDelete;

    private Long associationId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getOrdType() {
        return ordType;
    }

    public void setOrdType(String ordType) {
        this.ordType = ordType == null ? null : ordType.trim();
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber == null ? null : medicalNumber.trim();
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType == null ? null : appointmentType.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName == null ? null : surgeryName.trim();
    }

    public String getPerioperativeSurgery() {
        return perioperativeSurgery;
    }

    public void setPerioperativeSurgery(String perioperativeSurgery) {
        this.perioperativeSurgery = perioperativeSurgery == null ? null : perioperativeSurgery.trim();
    }

    public Date getSurgeryTime() {
        return surgeryTime;
    }

    public void setSurgeryTime(Date surgeryTime) {
        this.surgeryTime = surgeryTime;
    }

    public String getWoundPhotoIds() {
        return woundPhotoIds;
    }

    public void setWoundPhotoIds(String woundPhotoIds) {
        this.woundPhotoIds = woundPhotoIds == null ? null : woundPhotoIds.trim();
    }

    public Date getWoundPhotographyTime() {
        return woundPhotographyTime;
    }

    public void setWoundPhotographyTime(Date woundPhotographyTime) {
        this.woundPhotographyTime = woundPhotographyTime;
    }

    public String getTakingLens() {
        return takingLens;
    }

    public void setTakingLens(String takingLens) {
        this.takingLens = takingLens == null ? null : takingLens.trim();
    }

    public String getWoundCondition() {
        return woundCondition;
    }

    public void setWoundCondition(String woundCondition) {
        this.woundCondition = woundCondition == null ? null : woundCondition.trim();
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm == null ? null : isConfirm.trim();
    }

    public String getIsReservation() {
        return isReservation;
    }

    public void setIsReservation(String isReservation) {
        this.isReservation = isReservation == null ? null : isReservation.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Long getAssociationId() {
        return associationId;
    }

    public void setAssociationId(Long associationId) {
        this.associationId = associationId;
    }
}