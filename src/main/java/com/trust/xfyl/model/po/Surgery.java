package com.trust.xfyl.model.po;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.trust.xfyl.model.BaseBean;

import java.util.Date;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class Surgery extends BaseBean {
    private Long surgeryId;

    private Long trackingPersonnelId;

    private String surgeryType;

    private String surgeryName;

    private String operatingPhysician;

    private String woundPhotoUpload;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date surgeryTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date photoUploadTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;

    private String creator;

    private String fileId;

    private String busiType;

    private String url;

    private String ids;

    private Integer status;

    public Long getSurgeryId() {
        return surgeryId;
    }

    public void setSurgeryId(Long surgeryId) {
        this.surgeryId = surgeryId;
    }

    public Long getTrackingPersonnelId() {
        return trackingPersonnelId;
    }

    public void setTrackingPersonnelId(Long trackingPersonnelId) {
        this.trackingPersonnelId = trackingPersonnelId;
    }

    public String getSurgeryType() {
        return surgeryType;
    }

    public void setSurgeryType(String surgeryType) {
        this.surgeryType = surgeryType == null ? null : surgeryType.trim();
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName == null ? null : surgeryName.trim();
    }

    public String getOperatingPhysician() {
        return operatingPhysician;
    }

    public void setOperatingPhysician(String operatingPhysician) {
        this.operatingPhysician = operatingPhysician == null ? null : operatingPhysician.trim();
    }

    public String getWoundPhotoUpload() {
        return woundPhotoUpload;
    }

    public void setWoundPhotoUpload(String woundPhotoUpload) {
        this.woundPhotoUpload = woundPhotoUpload == null ? null : woundPhotoUpload.trim();
    }

    public Date getSurgeryTime() {
        return surgeryTime;
    }

    public void setSurgeryTime(Date surgeryTime) {
        this.surgeryTime = surgeryTime;
    }

    public Date getPhotoUploadTime() {
        return photoUploadTime;
    }

    public void setPhotoUploadTime(Date photoUploadTime) {
        this.photoUploadTime = photoUploadTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}