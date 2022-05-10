package com.remote.http;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName OkHttpTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/26 9:47
 */
public class OkHttpTest {
    public static void main(String[] args) {
        String url = "http://172.16.6.59:8086/fundDataManage/fundInfo/BasicInfo/004475";
        Map<String, String> map = new HashMap<>();
        /*map.put();
        map.put();*/

        post(url,map);


        String canonicalName = OkHttpTest.class.getCanonicalName();
        System.out.println(canonicalName);
        System.out.println(OkHttpTest.class.getName());

       /* Assert.isTrue(1==2,
                "@FeignClient can only be specified on an interface");

        System.out.println("3333333333333333");*/
     }
    public static void post(String url, Map<String,String> paramsMap){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder formbodyBuilder = new FormBody.Builder();
        Set<String> keySet = paramsMap.keySet();

        for (String key : keySet) {
            String value = paramsMap.get(key);
            formbodyBuilder.add(key, value);
        }

        FormBody build = formbodyBuilder.build();

        Request request = new Request.Builder().post(build).url(url).build();

        try(Response response = okHttpClient.newCall(request).execute()){
            System.out.println(response.body().string());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
