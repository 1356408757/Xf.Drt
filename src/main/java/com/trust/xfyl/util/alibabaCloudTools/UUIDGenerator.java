package com.trust.xfyl.util.alibabaCloudTools;

import java.util.UUID;

/**
 * TODO
 * 
 * @Description
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/

public class UUIDGenerator {
    public static String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }
}
