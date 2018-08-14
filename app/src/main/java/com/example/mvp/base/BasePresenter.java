package com.example.mvp.base;

/**
 * Created by GM on 2018/8/13.
 */

public interface BasePresenter<V> {

   void attach(V view);
   void death();

}
