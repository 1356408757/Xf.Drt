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

public class FoodSugar extends BaseBean {
    private Integer foodId;

    private String foodName;

    private String ediblePart;

    private String energy;

    private String water;

    private String protein;

    private String fat;

    private String dietaryFiber;

    private String carbohydrate;

    private String vitaminA;

    private String vitaminB1;

    private String vitaminB2;

    private String niacin;

    private String vitaminE;

    private String sodium;

    private String calcium;

    private String iron;

    private String category;

    private String vitaminC;

    private String cholesterol;

    private Date createTime;

    private String isDelete;

    private String foodPhoto;

    private String foodSugar;

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public String getEdiblePart() {
        return ediblePart;
    }

    public void setEdiblePart(String ediblePart) {
        this.ediblePart = ediblePart == null ? null : ediblePart.trim();
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy == null ? null : energy.trim();
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water == null ? null : water.trim();
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein == null ? null : protein.trim();
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat == null ? null : fat.trim();
    }

    public String getDietaryFiber() {
        return dietaryFiber;
    }

    public void setDietaryFiber(String dietaryFiber) {
        this.dietaryFiber = dietaryFiber == null ? null : dietaryFiber.trim();
    }

    public String getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(String carbohydrate) {
        this.carbohydrate = carbohydrate == null ? null : carbohydrate.trim();
    }

    public String getVitaminA() {
        return vitaminA;
    }

    public void setVitaminA(String vitaminA) {
        this.vitaminA = vitaminA == null ? null : vitaminA.trim();
    }

    public String getVitaminB1() {
        return vitaminB1;
    }

    public void setVitaminB1(String vitaminB1) {
        this.vitaminB1 = vitaminB1 == null ? null : vitaminB1.trim();
    }

    public String getVitaminB2() {
        return vitaminB2;
    }

    public void setVitaminB2(String vitaminB2) {
        this.vitaminB2 = vitaminB2 == null ? null : vitaminB2.trim();
    }

    public String getNiacin() {
        return niacin;
    }

    public void setNiacin(String niacin) {
        this.niacin = niacin == null ? null : niacin.trim();
    }

    public String getVitaminE() {
        return vitaminE;
    }

    public void setVitaminE(String vitaminE) {
        this.vitaminE = vitaminE == null ? null : vitaminE.trim();
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium == null ? null : sodium.trim();
    }

    public String getCalcium() {
        return calcium;
    }

    public void setCalcium(String calcium) {
        this.calcium = calcium == null ? null : calcium.trim();
    }

    public String getIron() {
        return iron;
    }

    public void setIron(String iron) {
        this.iron = iron == null ? null : iron.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(String vitaminC) {
        this.vitaminC = vitaminC == null ? null : vitaminC.trim();
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol == null ? null : cholesterol.trim();
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

    public String getFoodPhoto() {
        return foodPhoto;
    }

    public void setFoodPhoto(String foodPhoto) {
        this.foodPhoto = foodPhoto == null ? null : foodPhoto.trim();
    }

    public String getFoodSugar() {
        return foodSugar;
    }

    public void setFoodSugar(String foodSugar) {
        this.foodSugar = foodSugar == null ? null : foodSugar.trim();
    }
}