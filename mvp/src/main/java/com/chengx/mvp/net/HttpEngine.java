package com.chengx.mvp.net;



import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者：chengx
 * 日期：2017/2/10
 * 描述：
 */

public class HttpEngine {

    public static final int ERR_CODE_NETWORK_DISSABLE = -1;
    public static final String ERR_INFO_NETWORK_DISSABLE = "网络异常";
    public static final String TAG = "HttpEngine";

    private OkHttpClient client;
    public static HttpEngine instance;

    private HttpEngine(){
        client = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
    }

    public static HttpEngine getInstance(){
        if (instance == null) {
            instance = new HttpEngine();
        }
        return instance;
    }

    private String getUrl(String url,RequestParam params){
        String strParams = "?";
        if(params != null){
            Iterator<String> iterator = params.keySet().iterator();
            String key = "";
            while (iterator.hasNext()) {
                key = iterator.next();
                strParams += key + "=" + params.get(key)+"&";
            }
        }
        String result = url+strParams;
        return result.substring(0, result.lastIndexOf('&'));
    }

    /**
     * json解析（根据业务模型调整）
     *
     * @param <T> 解析结果
     * @return T
     */
//    private <T> T formatJson(String json){
//        Gson gson = new Gson();
//
//    }

    public <T> void get(String method, RequestParam param, final ResponseCallback<T> callback){
        String url = getUrl(RequestUrl.HOST + method, param);
        Request request = new Request.Builder()
                .url(url)
                .header("user-Agent","android")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure(ERR_CODE_NETWORK_DISSABLE,ERR_INFO_NETWORK_DISSABLE);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
//                com.chengx.mvp.biz.Response resp = formatJson(json);
            }
        });
    }
}
