package com.trust.xfyl.entity;

/**
 * @author Bay-max
 * @date 2024/4/22 14:01
 **/
public class TrustRelationFile {
    private String busiType;

    private String busiId;

    private String fileId;

    private String photoType;

    public String getBusiType() {
        return busiType;
    }

    public void setBusiType(String busiType) {
        this.busiType = busiType == null ? null : busiType.trim();
    }

    public String getBusiId() {
        return busiId;
    }

    public void setBusiId(String busiId) {
        this.busiId = busiId == null ? null : busiId.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }

    public String getPhotoType() {
        return photoType;
    }

    public void setPhotoType(String photoType) {
        this.photoType = photoType == null ? null : photoType.trim();
    }
}