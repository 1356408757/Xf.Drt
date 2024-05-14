package com.trust.xfyl.model.po;

import com.trust.xfyl.model.BaseBean;

import java.util.Date;
/**
 * TODO
 *
 * @Description
 * @author Bay-max
 * @date 2024/5/20 13:47
 **/

public class BloodSugar extends BaseBean {
    private Integer bloodId;

    private Integer userId;

    private Double sugarLevel;

    private String sugarTime;

    private Date sugarDate;

    private String sugarDiet;

    private String sugarExercise;

    private Date createTime;

    private String isDelete;

    private String sugarRemark;

    private String remarkPhoto;

    private Integer sugarTimeId;

    private Integer sugarDietId;

    public Integer getBloodId() {
        return bloodId;
    }

    public void setBloodId(Integer bloodId) {
        this.bloodId = bloodId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(Double sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public String getSugarTime() {
        return sugarTime;
    }

    public void setSugarTime(String sugarTime) {
        this.sugarTime = sugarTime == null ? null : sugarTime.trim();
    }

    public Date getSugarDate() {
        return sugarDate;
    }

    public void setSugarDate(Date sugarDate) {
        this.sugarDate = sugarDate;
    }

    public String getSugarDiet() {
        return sugarDiet;
    }

    public void setSugarDiet(String sugarDiet) {
        this.sugarDiet = sugarDiet == null ? null : sugarDiet.trim();
    }

    public String getSugarExercise() {
        return sugarExercise;
    }

    public void setSugarExercise(String sugarExercise) {
        this.sugarExercise = sugarExercise == null ? null : sugarExercise.trim();
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

    public String getSugarRemark() {
        return sugarRemark;
    }

    public void setSugarRemark(String sugarRemark) {
        this.sugarRemark = sugarRemark == null ? null : sugarRemark.trim();
    }

    public String getRemarkPhoto() {
        return remarkPhoto;
    }

    public void setRemarkPhoto(String remarkPhoto) {
        this.remarkPhoto = remarkPhoto == null ? null : remarkPhoto.trim();
    }

    public Integer getSugarTimeId() {
        return sugarTimeId;
    }

    public void setSugarTimeId(Integer sugarTimeId) {
        this.sugarTimeId = sugarTimeId;
    }

    public Integer getSugarDietId() {
        return sugarDietId;
    }

    public void setSugarDietId(Integer sugarDietId) {
        this.sugarDietId = sugarDietId;
    }
}