/*
package com.trust.xfyl.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.google.gson.Gson;
import com.aliyuncs.imageprocess.model.v20200320.*;





public class AliRunMedQA {

    public static void main(String[] args) {

        // Please ensure that the environment variables ALIBABA_CLOUD_ACCESS_KEY_ID and ALIBABA_CLOUD_ACCESS_KEY_SECRET are set.
        DefaultProfile profile = DefaultProfile.getProfile("cn-shanghai", System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"), System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"));

         DefaultProfile profile = DefaultProfile.getProfile(
         "<your-region-id>",           // The region ID
         System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"),       // The AccessKey ID of the RAM account
         System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"),   // The AccessKey Secret of the RAM account
         System.getenv("ALIBABA_CLOUD_SECURITY_TOKEN"));     // STS Token
         *


        IAcsClient client = new DefaultAcsClient(profile);


        RunMedQARequest request = new RunMedQARequest();

        try {
            RunMedQAResponse response = client.getAcsResponse(request);
            System.out.println(new Gson().toJson(response));
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            System.out.println("ErrCode:" + e.getErrCode());
            System.out.println("ErrMsg:" + e.getErrMsg());
            System.out.println("RequestId:" + e.getRequestId());
        }

    }
}
*/
