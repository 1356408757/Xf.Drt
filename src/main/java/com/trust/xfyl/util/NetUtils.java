package com.trust.xfyl.util;

import javax.servlet.http.HttpServletRequest;

/**
 * common utils
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class NetUtils {
    public static String getRealIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip)) {
            String[] ips = ip.split(",");
            ip = ips[0];
        }
        if (ip == null) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
