// This file is auto-generated, don't edit it. Thanks.
package cn.hxy.ymcc.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.core.http.HttpClient;
import com.aliyun.core.http.HttpMethod;
import com.aliyun.core.http.ProxyOptions;
import com.aliyun.httpcomponent.httpclient.ApacheAsyncHttpClientBuilder;
import com.aliyun.sdk.service.dysmsapi20170525.models.*;
import com.aliyun.sdk.service.dysmsapi20170525.*;
import com.google.gson.Gson;
import darabonba.core.RequestConfiguration;
import darabonba.core.client.ClientOverrideConfiguration;
import darabonba.core.utils.CommonUtil;
import darabonba.core.TeaPair;

//import javax.net.ssl.KeyManager;
//import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.io.*;
import java.util.concurrent.ExecutionException;

/*
* 短信
* */
public class SendSmsUtil {
    public static void sendSms(String phone,String code){

//        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
//                // Please ensure that the environment variables ALIBABA_CLOUD_ACCESS_KEY_ID and ALIBABA_CLOUD_ACCESS_KEY_SECRET are set.
//                .accessKeyId(System.getenv(""))
//                .accessKeySecret(System.getenv(""))
//                //.securityToken(System.getenv("ALIBABA_CLOUD_SECURITY_TOKEN")) // use STS token
//                .build());
//        // Configure the Client
//        AsyncClient client = AsyncClient.builder()
//                .region("cn-qingdao") // Region ID
//                    .credentialsProvider(provider)
//
//                .overrideConfiguration(
//                        ClientOverrideConfiguration.create()
//                                  // Endpoint 请参考 https://api.aliyun.com/product/Dysmsapi
//                                .setEndpointOverride("dysmsapi.aliyuncs.com")
//                )
//                .build();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("code",code);
//        String jsonString = jsonObject.toJSONString();
//        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
//                .phoneNumbers(phone)
//                .signName("阿里云短信测试")
//                .templateCode("SMS_325305191")
//                .templateParam(jsonString)
//                .build();
//        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
//        SendSmsResponse resp = null;
//        try {
//            resp = response.get();
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//        System.out.println(new Gson().toJson(resp));
//        client.close();
    }

}
