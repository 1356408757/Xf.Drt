package com.trust.xfyl.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class TrackingPersonnel extends BaseBean {
    private Long id;

    private String name;

    private String barcodePhoto;

    private String medicalNumber;

    private String phone;

    private String operationName;

    private Date operationDate;

    private String surgeonName;

    private String attendingDoctorName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date creatTime;

    private String creatName;

    private Long surgeonId;

    private Long attendingDoctor;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBarcodePhoto() {
        return barcodePhoto;
    }

    public void setBarcodePhoto(String barcodePhoto) {
        this.barcodePhoto = barcodePhoto == null ? null : barcodePhoto.trim();
    }

    public String getMedicalNumber() {
        return medicalNumber;
    }

    public void setMedicalNumber(String medicalNumber) {
        this.medicalNumber = medicalNumber == null ? null : medicalNumber.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public String getSurgeonName() {
        return surgeonName;
    }

    public void setSurgeonName(String surgeonName) {
        this.surgeonName = surgeonName == null ? null : surgeonName.trim();
    }

    public String getAttendingDoctorName() {
        return attendingDoctorName;
    }

    public void setAttendingDoctorName(String attendingDoctorName) {
        this.attendingDoctorName = attendingDoctorName == null ? null : attendingDoctorName.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getCreatName() {
        return creatName;
    }

    public void setCreatName(String creatName) {
        this.creatName = creatName == null ? null : creatName.trim();
    }

    public Long getSurgeonId() {
        return surgeonId;
    }

    public void setSurgeonId(Long surgeonId) {
        this.surgeonId = surgeonId;
    }

    public Long getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(Long attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
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