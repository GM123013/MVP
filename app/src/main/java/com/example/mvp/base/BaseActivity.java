package com.example.mvp.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by GM on 2018/8/13.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    public P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getLayoutId());
        initView();
    }

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected void parsePresenter(){
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        Type[] typeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        
    }
}
