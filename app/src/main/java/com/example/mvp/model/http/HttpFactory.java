package com.example.mvp.model.http;

/**
 * Created by GM on 2018/8/13.
 * 网络请求工厂类
 */

public class HttpFactory {
    //返回父类接口
    public static IHttp create() {
        return HttpUtils.getInstance();
    }
}
