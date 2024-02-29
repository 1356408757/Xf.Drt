package com.trust.xfyl.util;

import com.aliyun.com.viapi.FileUtils;

/**
* @Author djj
* @Description //TODO
* @Date 14:32 2024/2/26
**/
public class AliFileUrlUtils {
    /**
     * @return java.lang.String
     * @Author djj
     * @Description 场景一，使用本地文件 : String file = "/tmp/bankCard.png";
     * 场景二，使用任意可访问的url: String url="https://magicpic-p.cdn.bcebos.com/atlas/68cf3c9a369558ca4ffddf35ac396617.jpg";
     * @Date 14:47 2024/1/29
     * @Param [accessKeyId, accessKeySecret, Url]
     **/
    public static String getFileUrl(String accessKeyId, String accessKeySecret, String url) throws Exception {
        if (accessKeyId != null && accessKeySecret != null && url != null) {
            FileUtils fileUtils = FileUtils.getInstance(accessKeyId, accessKeySecret);

            String ossUrl = fileUtils.upload(url);
            // 生成的url，可用于调用视觉智能开放平台的能力
            System.out.println(ossUrl);
            return ossUrl;
        } else {
            return null;
        }

    }

}
