package com.trust.xfyl.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class WoundOrderVo {

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date surgeryTime;

    private String woundPhotoIds;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date woundPhotographyTime;

    private String takingLens;

    private String woundCondition;

    private String isConfirm;

    private String isReservation;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String creator;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private Integer isDelete;

    private String doctorName;

    private String doctorType;

    private String doctorIntroduce;

    private String doctorPhoto;

    private String doctorServices;

    private String name;

    private String barcodePhoto;

    private String phone;

    private String fileId;

    private String url;

    private String tarkFileId;

    private String tarkUrl;

    private String doctorFileId;

    private String doctorUrl;

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
        this.orderNumber = orderNumber;
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
        this.ordType = ordType;
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
        this.business = business;
    }

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }

    public String getPerioperativeSurgery() {
        return perioperativeSurgery;
    }

    public void setPerioperativeSurgery(String perioperativeSurgery) {
        this.perioperativeSurgery = perioperativeSurgery;
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
        this.woundPhotoIds = woundPhotoIds;
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
        this.takingLens = takingLens;
    }

    public String getWoundCondition() {
        return woundCondition;
    }

    public void setWoundCondition(String woundCondition) {
        this.woundCondition = woundCondition;
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm;
    }

    public String getIsReservation() {
        return isReservation;
    }

    public void setIsReservation(String isReservation) {
        this.isReservation = isReservation;
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
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(String doctorType) {
        this.doctorType = doctorType;
    }

    public String getDoctorIntroduce() {
        return doctorIntroduce;
    }

    public void setDoctorIntroduce(String doctorIntroduce) {
        this.doctorIntroduce = doctorIntroduce;
    }

    public String getDoctorPhoto() {
        return doctorPhoto;
    }

    public void setDoctorPhoto(String doctorPhoto) {
        this.doctorPhoto = doctorPhoto;
    }

    public String getDoctorServices() {
        return doctorServices;
    }

    public void setDoctorServices(String doctorServices) {
        this.doctorServices = doctorServices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarcodePhoto() {
        return barcodePhoto;
    }

    public void setBarcodePhoto(String barcodePhoto) {
        this.barcodePhoto = barcodePhoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarkFileId() {
        return tarkFileId;
    }

    public void setTarkFileId(String tarkFileId) {
        this.tarkFileId = tarkFileId;
    }

    public String getTarkUrl() {
        return tarkUrl;
    }

    public void setTarkUrl(String tarkUrl) {
        this.tarkUrl = tarkUrl;
    }

    public String getDoctorFileId() {
        return doctorFileId;
    }

    public void setDoctorFileId(String doctorFileId) {
        this.doctorFileId = doctorFileId;
    }

    public String getDoctorUrl() {
        return doctorUrl;
    }

    public void setDoctorUrl(String doctorUrl) {
        this.doctorUrl = doctorUrl;
    }
}
