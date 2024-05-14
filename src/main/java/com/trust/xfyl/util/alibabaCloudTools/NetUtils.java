package com.trust.xfyl.util.alibabaCloudTools;

import javax.servlet.http.HttpServletRequest;

/**
 * NetUtils类，提供网络相关的工具方法。
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class NetUtils {
    /**
     * 获取客户端真实IP地址。
     * 首先尝试从HTTP头中的X-Forwarded-For字段获取IP地址，如果没有则尝试从X-Real-IP字段获取，
     * 如果还是没有，则从HttpServletRequest的RemoteAddr属性中获取。
     *
     * @param request 客户端请求，用于获取客户端IP地址。
     * @return 客户端真实IP地址，如果无法获取则返回null。
     */
    public static String getRealIp(HttpServletRequest request) {
        // 尝试从X-Forwarded-For头获取IP
        String ip = request.getHeader("X-Forwarded-For");
        if (ip != null && !"".equals(ip)) {
            // 处理可能的多个IP地址的情况，只取第一个
            String[] ips = ip.split(",");
            ip = ips[0];
        }
        // 如果X-Forwarded-For头不存在，尝试从X-Real-IP头获取
        if (ip == null) {
            ip = request.getHeader("X-Real-IP");
        }
        // 如果X-Real-IP头也不存在，使用请求的RemoteAddr属性
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        // 返回获取到的IP地址
        return ip;
    }

}
