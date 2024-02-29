package com.trust.xfyl.enums;

/**
 * @author LENOVO
 */

public enum PhotoEnum {

    One(1, "病例照片"),
    Two(2, "术前照片"),
    Three(3, "术中照片"),
    Four(4, "术后即刻"),
    Five(5, "术后第一天"),
    Six(6, "术后第二天"),
    Seven(7, "术后第三天"),
    Eight(8, "术后第四天"),
    Nine(9, "术后第五天"),
    Ten(10, "术后第六天"),
    Eleven(11, "术后第七天"),
    Twelve(12, "术后第二周"),
    Thirteen(13, "术后第三周"),
    Fourteen(14, "标题");

    private Integer status;
    private String message;

    PhotoEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    PhotoEnum() {
    }

    /**
     * 返回枚举值根据状态
     *
     * @param status
     * @return
     */
    public static String getMsg(Integer status) {
        switch (status) {
            case 1: {
                return One.getMessage();
            }
            case 2: {
                return Two.getMessage();
            }
            case 3: {
                return Three.getMessage();
            }
            case 4: {
                return Four.getMessage();
            }
            case 5: {
                return Five.getMessage();
            }
            case 6: {
                return Six.getMessage();
            }
            case 7: {
                return Seven.getMessage();
            }
            case 8: {
                return Eight.getMessage();
            }
            case 9: {
                return Nine.getMessage();
            }
            case 10: {
                return Ten.getMessage();
            }
            case 11: {
                return Eleven.getMessage();
            }
            case 12: {
                return Twelve.getMessage();
            }
            case 13: {
                return Thirteen.getMessage();
            }
            case 14: {
                return Fourteen.getMessage();
            }
            default:
                throw new IllegalStateException("Unexpected value: " + status);
        }

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
