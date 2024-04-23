package com.trust.xfyl.util;

import com.alibaba.fastjson.JSON;
import com.trust.xfyl.entity.dto.AppConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 应用日志工具类，用于监控和跟踪
 *
 * @author Bay-max
 * @date 2024/4/22 15:39
 **/
public class LogUtils {

    public static final String SIMPLE_LOG_SPLIT = "@@@";
    private final static Logger logger = LoggerFactory.getLogger(LogUtils.class);
    private final static Logger monitorLogger = LoggerFactory.getLogger("monitor-log");
    private final static Logger traceLogger = LoggerFactory.getLogger("trace-log");

    /**
     * 输出调试日志
     *
     * @param objects 要记录的日志内容
     */
    public static void debug(Object... objects) {
        LogContent build = build(objects);
        logger.debug(build.logData);
    }

    /**
     * 输出信息日志
     *
     * @param objects 要记录的日志内容
     */
    public static void info(Object... objects) {
        LogContent build = build(objects);
        logger.info(build.logData);
    }

    /**
     * 输出警告日志
     *
     * @param objects 要记录的日志内容
     */
    public static void warn(Object... objects) {
        LogContent build = build(objects);
        logger.warn(build.logData);
    }

    /**
     * 输出错误日志
     *
     * @param objects 要记录的日志内容
     */
    public static void error(Object... objects) {
        LogContent build = build(objects);
        logger.error(build.logData, build.getThrowable());
    }

    /**
     * 记录监控日志
     *
     * @param requestId   请求ID
     * @param serviceName 服务名称
     * @param methodName  方法名称
     * @param errorCode   错误码
     * @param startTime   开始时间
     * @param objects     其他日志内容
     */
    public static void monitor(String requestId, String serviceName, String methodName,
                               String errorCode, Long startTime, Object... objects) {
        ResultStatus status = StringUtils.isNotBlank(errorCode) ? ResultStatus.FAIL : ResultStatus.SUCCESS;
        StringBuilder builder = new StringBuilder();
        // 构建日志内容
        builder.append(requestId);
        builder.append(SIMPLE_LOG_SPLIT).append(serviceName);
        builder.append(SIMPLE_LOG_SPLIT).append(methodName);
        builder.append(SIMPLE_LOG_SPLIT).append(status.name());
        builder.append(SIMPLE_LOG_SPLIT).append(errorCode);

        Long costTime = 0L;
        if (startTime != null) {
            costTime = System.currentTimeMillis() - startTime;
        }
        builder.append(SIMPLE_LOG_SPLIT).append(costTime);

        LogContent content = build(objects);
        appendLogData(builder, content);

        String logStr = builder.toString();
        monitorLogger.error(logStr);
        if (content.getThrowable() != null) {
            logger.error(logStr, content.getThrowable());
        }
    }

    /**
     * 记录跟踪日志
     *
     * @param requestId  请求ID
     * @param action     动作描述
     * @param resultCode 结果码
     * @param startTime  开始时间
     * @param input      输入数据
     * @param output     输出数据
     * @param objects    其他日志内容
     */
    public static void trace(String requestId, String action, String resultCode, Long startTime,
                             Object input, Object output, Object... objects) {
        if (!AppConfig.openTrace) {
            return;
        }

        StringBuilder tracer = new StringBuilder();
        tracer.append("Trace").append(SIMPLE_LOG_SPLIT)
                .append(requestId).append(SIMPLE_LOG_SPLIT);

        tracer.append(action).append(SIMPLE_LOG_SPLIT);
        tracer.append(resultCode).append(SIMPLE_LOG_SPLIT);

        Long costTime = 0L;
        if (startTime != null) {
            costTime = System.currentTimeMillis() - startTime;
        }

        tracer.append(costTime).append(SIMPLE_LOG_SPLIT);
        tracer.append(JSON.toJSONString(input)).append(SIMPLE_LOG_SPLIT);
        tracer.append(JSON.toJSONString(output)).append(SIMPLE_LOG_SPLIT);

        LogContent content = build(objects);
        appendLogData(tracer, content);

        traceLogger.info(tracer.toString());
    }

    /**
     * 构建日志内容
     *
     * @param objects 要记录的日志对象
     * @return 构建好的日志内容实例
     */
    private static LogContent build(Object... objects) {
        LogContent logContent = new LogContent();
        if (null == objects || objects.length == 0) {
            return logContent;
        }

        StringBuilder builder = new StringBuilder();

        Throwable throwable = null;
        for (Object obj : objects) {
            if (obj instanceof Throwable) {
                throwable = (Throwable) obj;
                continue;
            }

            String value;
            if (obj instanceof String) {
                value = String.valueOf(obj);
            } else {
                value = JSON.toJSONString(obj);
            }

            builder.append(SIMPLE_LOG_SPLIT).append(value);
        }

        logContent.setLogData(builder.toString());
        logContent.setThrowable(throwable);

        return logContent;
    }

    /**
     * 向StringBuilder追加日志数据
     *
     * @param builder    StringBuilder实例
     * @param logContent 日志内容
     */
    private static void appendLogData(StringBuilder builder, LogContent logContent) {
        if (logContent.getThrowable() != null) {
            builder.append(SIMPLE_LOG_SPLIT).append(logContent.getThrowable().getMessage());
        }
        builder.append(logContent.getLogData());
    }

    /**
     * 调用结果状态
     */
    public enum ResultStatus {
        /**
         * 调用成功
         */
        SUCCESS,

        /**
         * 调用失败
         */
        FAIL
    }

    @Data
    static class LogContent {

        String logData; // 日志数据

        Throwable throwable; // 异常信息
    }
}
