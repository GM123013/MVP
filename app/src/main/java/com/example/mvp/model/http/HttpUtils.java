package com.example.mvp.model.http;

import com.example.mvp.model.callback.NetworkCallback;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by GM on 2018/8/13.
 */

public class HttpUtils implements IHttp {
    private static HttpUtils httpUtils;
    private OkHttpClient okHttpClient;

    private HttpUtils() {
        okHttpClient = new OkHttpClient.Builder().build();
    }

    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    /**
     * @param url
     * @param callback
     * @param <T>
     */
    @Override
    public <T> void doGet(String url, final NetworkCallback<T> callback) {
        Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                T t = parseT(string, callback);
                callback.onSuccess(t);
            }
        });
    }

    @Override
    public <T> void doGet(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void doPost(String url, Map<String, String> params, NetworkCallback<T> callback) {

    }

    @Override
    public <T> void doPost(String url, Map<String, File> files, Map<String, String> params, NetworkCallback<T> callback) {

    }

    /**
     * 把字符串解析成实体类
     *
     * @param data     解析的json串
     * @param callback 获取回调中的实体类
     * @param <T>
     * @return 返回解析好的对象
     */
    private <T> T parseT(String data, NetworkCallback<T> callback) {
        Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
        Type[] typeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
        Class<T> tClass = (Class<T>) typeArguments[0];
        T t = new Gson().fromJson(data, tClass);
        return t;
    }
}
