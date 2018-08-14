package com.example.mvp.model.http;

import com.example.mvp.model.callback.NetworkCallback;

import java.io.File;
import java.util.Map;

/**
 * Created by GM on 2018/8/13.
 */

public interface IHttp {

    <T> void doGet(String url, NetworkCallback<T> callback);

    <T> void doGet(String url, Map<String, String> params, NetworkCallback<T> callback);

    <T> void doPost(String url, Map<String, String> params, NetworkCallback<T> callback);

    <T> void doPost(String url, Map<String, File> files, Map<String, String> params, NetworkCallback<T> callback);


}
