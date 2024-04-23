package com.trust.xfyl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class WoundFollow extends BaseBean {
    private Long id;

    private Long trackingPersonnelId;

    private String medicalNumber;

    private Integer doctorId;

    private String doctorName;

    private String postoperativeStage;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date woundShootingDate;

    private String takingLens;

    private String woundPhoto;

    private String woundCondition;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private String creator;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    private String updateName;

    private Integer isDelete;

    private String isConfirm;

    private String fileId;

    private String busiType;

    private String url;

    private String ids;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrackingPersonnelId() {
        return trackingPersonnelId;
    }

    public void setTrackingPersonnelId(Long trackingPersonnelId) {
        this.trackingPersonnelId = trackingPersonnelId;
    }

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber == null ? null : medicalNumber.trim();
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getPostoperativeStage() {
        return postoperativeStage;
    }

    public void setPostoperativeStage(String postoperativeStage) {
        this.postoperativeStage = postoperativeStage == null ? null : postoperativeStage.trim();
    }

    public Date getWoundShootingDate() {
        return woundShootingDate;
    }

    public void setWoundShootingDate(Date woundShootingDate) {
        this.woundShootingDate = woundShootingDate;
    }

    public String getTakingLens() {
        return takingLens;
    }

    public void setTakingLens(String takingLens) {
        this.takingLens = takingLens == null ? null : takingLens.trim();
    }

    public String getWoundPhoto() {
        return woundPhoto;
    }

    public void setWoundPhoto(String woundPhoto) {
        this.woundPhoto = woundPhoto == null ? null : woundPhoto.trim();
    }

    public String getWoundCondition() {
        return woundCondition;
    }

    public void setWoundCondition(String woundCondition) {
        this.woundCondition = woundCondition == null ? null : woundCondition.trim();
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

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(String isConfirm) {
        this.isConfirm = isConfirm == null ? null : isConfirm.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}