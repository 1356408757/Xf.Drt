/*
package com.trust.xfyl.util;

import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.broadscope.bailian.sdk.ApplicationClient;
import com.aliyun.broadscope.bailian.sdk.models.CompletionsRequest;
import com.aliyun.broadscope.bailian.sdk.models.CompletionsResponse;
import com.aliyun.sdk.service.bailian20230601.AsyncClient;
import com.aliyun.sdk.service.bailian20230601.models.CreateTokenRequest;
import com.aliyun.sdk.service.bailian20230601.models.CreateTokenResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import darabonba.core.client.ClientOverrideConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;



@Component
public class CreateToken {
    private static final Logger logger = LoggerFactory.getLogger(CreateToken.class);
    private static final long PERIOD = 600;
    private static String token;

    public static String getToken() {
        return token;
    }
    @Scheduled(fixedRate = PERIOD * 1000)
    public static void createToken() {
        try {
            StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                    .accessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                    .accessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"))
                    .build());

            AsyncClient client = AsyncClient.builder()
                    .region("cn-beijing")
                    .credentialsProvider(provider)
                    .overrideConfiguration(
                            ClientOverrideConfiguration.create()
                                    .setEndpointOverride("bailian.cn-beijing.aliyuncs.com")
                                    .setConnectTimeout(Duration.ofSeconds(30))
                    )
                    .build();

            CreateTokenRequest createTokenRequest = CreateTokenRequest.builder()
                    .agentKey(System.getenv("AGENT_KEY"))
                    .build();

            CompletableFuture<CreateTokenResponse> response = client.createToken(createTokenRequest);
            CreateTokenResponse resp = response.get();
            String createToken = new Gson().toJson(resp);
            logger.info("createToken============"+createToken);
            token = CreateToken.parseToken(createToken);
            logger.info("token============"+token);
            client.close();

        } catch (Exception e) {
            System.err.println("Failed to create token: " + e.getMessage());
        }
    }
*
     * TODO
     *
     * @Description
     * @return com.trust.xfyl.entity.ResultVO
     * @Author Bay-max
     * @Param botText
     * @Param prompt
     * @Date 2024/3/7 11:09
     *


    public static CompletionsResponse modelCompletions(String botText, String prompt) {
        ApplicationClient client = ApplicationClient.builder()
                .token(token)
                .build();

        List<CompletionsRequest.ChatQaPair> chatQaPairs = new ArrayList<>();
        CompletionsRequest.ChatQaPair chatQaPair = new CompletionsRequest.ChatQaPair();
        chatQaPair.setBot(botText);
        chatQaPair.setUser(prompt);

        CompletionsRequest request = new CompletionsRequest()
                .setAppId(System.getenv("DRT_LS_THREE_APP_ID"))
                .setPrompt(prompt)
                .setHistory(chatQaPairs);

        CompletionsResponse response = client.completions(request);
        if (!response.isSuccess()) {
            logger.error(response.getRequestId(), response.getCode(), response.getMessage());
        }
        CompletionsResponse.Data data = response.getData();
        logger.info("response================" + response.toString());
        // 返回成功结果
        return response;
    }

    public static String parseToken(String jsonString) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);

        return jsonObject.getAsJsonObject("body")
                .getAsJsonObject("data")
                .get("token")
                .getAsString();
    }

}
*/
