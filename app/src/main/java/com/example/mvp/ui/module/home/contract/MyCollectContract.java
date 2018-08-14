package com.example.mvp.ui.module.home.contract;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.base.BaseView;
import com.example.mvp.model.entity.User;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public interface MyCollectContract {
    interface View extends BaseView {
        void showProgressBar();

        void dismissProgressBar();

        void showListData(List<User> list);
    }

    interface Presenter extends BasePresenter<View> {
        void getProgressBar();

        void dismissProgressBar();

        void getDbData();
    }
}
