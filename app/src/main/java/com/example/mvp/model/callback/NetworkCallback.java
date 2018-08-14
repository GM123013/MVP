package com.example.mvp.model.callback;

/**
 * Created by GM on 2018/8/13.
 */

public interface NetworkCallback<T> {
    void onSuccess(T t);

    void onError(String errorMsg);
}
