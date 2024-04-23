package com.trust.xfyl.entity;

import java.math.BigDecimal;
import java.util.Date;
/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class CreditPackages extends BaseBean {
    private Integer packageId;

    private String packageName;

    private BigDecimal price;

    private Integer creditsPerPackage;

    private Date createTime;

    private Integer isDelete;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCreditsPerPackage() {
        return creditsPerPackage;
    }

    public void setCreditsPerPackage(Integer creditsPerPackage) {
        this.creditsPerPackage = creditsPerPackage;
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