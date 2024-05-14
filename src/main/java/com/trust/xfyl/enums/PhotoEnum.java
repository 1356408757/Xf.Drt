package com.trust.xfyl.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 照片类型枚举，用于定义不同类型的手术照片。
 * 提供了根据状态码获取对应照片类型描述信息的功能。
 *
 * @author Bay-max
 * @date 2024/4/22 15:36
 **/
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

    // 状态码与照片类型枚举值的映射，用于快速根据状态码获取枚举实例
    private static final Map<Integer, PhotoEnum> STATUS_MAP = new HashMap<>();

    static {
        // 初始化映射表
        for (PhotoEnum e : PhotoEnum.values()) {
            STATUS_MAP.put(e.status, e);
        }
    }

    // 状态码
    private final Integer status;
    // 状态描述信息
    private final String message;

    /**
     * 构造函数，用于初始化枚举值。
     *
     * @param status 状态码。
     * @param message 状态描述信息。
     */
    PhotoEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    /**
     * 根据状态码获取对应的照片类型描述信息。
     *
     * @param status 状态码。
     * @return 对应状态的描述信息。
     * @throws IllegalStateException 如果传入的状态码不属于任何枚举值，则抛出异常。
     */
    public static String getMsg(Integer status) {
        PhotoEnum enumValue = STATUS_MAP.get(status);
        if (enumValue == null) {
            throw new IllegalStateException("Unexpected value: " + status);
        }
        return enumValue.message;
    }

    // Getter方法，用于外部访问枚举实例的属性
    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
