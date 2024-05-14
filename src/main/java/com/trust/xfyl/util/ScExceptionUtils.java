package com.trust.xfyl.util;

/**
 * @author big-max
 * @title ScExceptionUtil
 * @date 2024/5/27 11:56
 * @description TODO
 */
public class ScExceptionUtils {
    /**
     * 清理错误信息，将错误信息分为错误类型和堆栈信息，并对堆栈信息进行简化和敏感信息替换。
     *
     * @param errorMessage 原始错误信息，格式为“错误类型: 堆栈信息”。
     * @return 清理后的错误信息，包含错误类型和简化、脱敏后的堆栈信息。
     */
    public static String sanitizeErrorMessage(String errorMessage) {
        // 分割错误信息为错误类型和堆栈信息
        String[] errorParts = errorMessage.split(": ", 2);
        String errorType = errorParts[0];
        String stackTrace = errorParts.length > 1 ? errorParts[1] : "";
        // 初始化用于存储清理后的堆栈信息的StringBuilder
        // 定义最大堆栈行数
        int maxStackTraceLines = 5;
        String[] stackTraceLines = stackTrace.split("\n");
        StringBuilder sanitizedStackTrace = new StringBuilder();
        for (int i = 0; i < Math.min(stackTraceLines.length, maxStackTraceLines); i++) {
            // 对每行堆栈信息进行敏感信息替换
            String line = stackTraceLines[i];
            sanitizedStackTrace.append(line.replaceAll("(?i)jdbc:mysql://.*@", "jdbc:mysql://****@"))
                    .append("\n");
        }
        // 如果堆栈信息超过最大行数，追加省略号
        if (stackTraceLines.length > maxStackTraceLines) {
            sanitizedStackTrace.append("...\n");
        }
        // 返回错误类型和清理后的堆栈信息
        return errorType + ": " + sanitizedStackTrace;
    }
}
