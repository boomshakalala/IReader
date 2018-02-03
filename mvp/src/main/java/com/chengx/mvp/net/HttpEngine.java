package com.chengx.mvp.net;



import com.chengx.mvp.utils.KLog;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import de.greenrobot.event.EventBus;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 作者：chengx
 * 日期：2017/2/10
 * 描述：
 */

public class HttpEngine {

    public static final int ERR_CODE_NETWORK_DISSABLE = -1;
    public static final String ERR_INFO_NETWORK_DISSABLE = "网络异常";
    public static final int ERR_CODE_JSON_SYNTAX = -2;
    public static final String ERR_INFO_JSON_SYNTAX = "数据解析异常";
    private static final int NETWORK_SUCCESS = 0;
    public static final String TAG = "HttpEngine";

    private OkHttpClient client;
    public static HttpEngine instance;

    private HttpEngine(){
        client = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .build();
        EventBus.getDefault().register(this);

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
    private <T> ApiResponse<T> formatJson(String json,Type typeOfClass){
        Gson gson = new Gson();
        ApiResponse<T> response = new ApiResponse<>();
        JsonParser parser = new JsonParser();
        try {
            JsonObject jsonObject = parser.parse(json).getAsJsonObject();
            if (jsonObject.has("code")){
                response.setCode(jsonObject.get("code").getAsInt());
            }
            if (jsonObject.has("message")){
                String message = jsonObject.get("message").getAsString();
                response.setMessage(message.isEmpty()?"未知错误":message);
            }
            if (jsonObject.has("data")&&!(typeOfClass==Void.class)){
                String jsonDataStr = jsonObject.get("data").toString();
                T data = gson.fromJson(jsonDataStr,typeOfClass);
                response.setData(data);
            }
            return response;
        }catch (Exception e){
            KLog.e(TAG,e.getMessage());
            return response;
        }
    }

    public <T> void get(String url, RequestParam param, final Type typeOfClass, final ResponseCallback<T> callback){
        url = getUrl(url, param);
        Request request = new Request.Builder()
                .url(url)
                .header("user-Agent","android")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                com.chengx.mvp.net.Response<T> resp = new com.chengx.mvp.net.Response<>();
                resp.code = ERR_CODE_NETWORK_DISSABLE;
                resp.json = ERR_INFO_NETWORK_DISSABLE;
                resp.callback = callback;
                EventBus.getDefault().post(resp);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                com.chengx.mvp.net.Response<T> resp = new com.chengx.mvp.net.Response<>();
                resp.code = NETWORK_SUCCESS;
                resp.json = response.body().string();
                resp.callback = callback;
                resp.typeOfClass = typeOfClass;
                EventBus.getDefault().post(resp);
            }
        });
    }

    public <T> void wxGet(String url, RequestParam param , final ResponseCallback<T> callback){
        url = getUrl(url, param);
        Request request = new Request.Builder()
                .url(url)
                .header("user-Agent","android")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                com.chengx.mvp.net.Response<T> resp = new com.chengx.mvp.net.Response<>();
                resp.code = ERR_CODE_NETWORK_DISSABLE;
                resp.json = ERR_INFO_NETWORK_DISSABLE;
                resp.callback = callback;
                EventBus.getDefault().post(resp);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                com.chengx.mvp.net.Response<T> resp = new com.chengx.mvp.net.Response<>();
                resp.code = NETWORK_SUCCESS;
                resp.json = response.body().string();
                resp.fromWxApi = true;
                resp.callback = callback;
                EventBus.getDefault().post(resp);
            }
        });
    }

    public <T> void post(String url,RequestParam param,final Type typeOfClass,final ResponseCallback<T> callback){
        KLog.d(TAG,param);
        KLog.d(TAG,url);
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<Map.Entry<String,String>> iterator = param.entrySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next().getKey();
            String value =  param.get(key);
            builder.add(key,value);
        }
        RequestBody body = builder.build();
        Request request = new Request.Builder()
                .url(url)
                .header("user-Agent","android")
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                com.chengx.mvp.net.Response<T> resp = new com.chengx.mvp.net.Response<>();
                resp.code = ERR_CODE_NETWORK_DISSABLE;
                resp.json = ERR_INFO_NETWORK_DISSABLE;
                resp.callback = callback;
                EventBus.getDefault().post(resp);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                com.chengx.mvp.net.Response resp = new com.chengx.mvp.net.Response();
                resp.code = NETWORK_SUCCESS;
                resp.json = response.body().string();
                resp.callback = callback;
                resp.typeOfClass = typeOfClass;
                EventBus.getDefault().post(resp);
            }
        });

    }

    public void onEventMainThread(com.chengx.mvp.net.Response resp){
        switch (resp.code){
            case ERR_CODE_NETWORK_DISSABLE:
                if (resp.callback != null){
                    String info = resp.json;
                    resp.callback.onFailure(ERR_CODE_NETWORK_DISSABLE,info);
                }
                break;
            case NETWORK_SUCCESS:
                KLog.json(resp.json);
                if (resp.callback != null){
                    if (resp.fromWxApi){
                        WXApiResponse wxResponse = new Gson().fromJson(resp.json,WXApiResponse.class);
                        if (wxResponse != null){
                            if (wxResponse.getErrcode() == 0) {
                                resp.callback.onSuccess(wxResponse);
                            } else {
                                KLog.d(TAG, "onSuccess errorCode=" + wxResponse.getErrcode());
                                KLog.d(TAG, "onSuccess errorMsg=" + wxResponse.getErrmsg());
                                resp.callback.onFailure(wxResponse.getErrcode(), wxResponse.getErrmsg());
                            }
                        }
                    }else {
                        ApiResponse response = formatJson(resp.json,resp.typeOfClass);
                        if (response.isSuccess()){
                            if (resp.typeOfClass.equals(Void.class))
                                resp.callback.onSuccess(null);
                            if (response.getData() != null) {
                                resp.callback.onSuccess(response.getData());
                            }
                        }else {
                            KLog.e(TAG,response.getMessage());
                            resp.callback.onFailure(response.getCode(),response.getMessage());
                        }
                    }
                }
                break;
        }
    }


}
