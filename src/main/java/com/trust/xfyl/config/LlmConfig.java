package com.trust.xfyl.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Lvmh LLM config
 *
 * @author yuanci
 */
@Configuration
@ConfigurationProperties(prefix = "chat.llm")
@Data
public class LlmConfig {
    /**
     * access key id of aliyun account
     */
    private String accessKeyId;

    /**
     * access key secret of aliyun account
     */
    private String accessKeySecret;

    /**
     * agent key of bailian business space
     */
    private String agentKey;

    /**
     * application id of bailian for text chat
     */
    private String appId;

    /**
     * request time out of LLM
     */
    private Integer timeout = 60;

    public String getAccessKeyId() {
        String val = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        if (StringUtils.isNotBlank(val)) {
            return val;
        }

        return accessKeyId;
    }

    public String getAccessKeySecret() {
        String val = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        if (StringUtils.isNotBlank(val)) {
            return val;
        }

        return accessKeySecret;
    }
    public String getAgentKey() {
        String val = System.getenv("AGENT_KEY");
        if (StringUtils.isNotBlank(val)) {
            return val;
        }

        return agentKey;
    }

    public String getAppId() {
        String val = System.getenv("DRT_LS_THREE_APP_ID");
        if (StringUtils.isNotBlank(val)) {
            return val;
        }
        return appId;
    }

}
