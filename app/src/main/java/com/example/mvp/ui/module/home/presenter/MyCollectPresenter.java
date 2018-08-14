package com.example.mvp.ui.module.home.presenter;

import com.example.mvp.model.biz.HomeModel;
import com.example.mvp.model.biz.IHomeModel;
import com.example.mvp.model.db.DbUtils;
import com.example.mvp.model.entity.User;
import com.example.mvp.ui.module.home.contract.MyCollectContract;

import java.util.List;
import java.util.logging.Handler;

/**
 * Created by GM on 2018/8/13.
 */

public class MyCollectPresenter implements MyCollectContract.Presenter {

    private IHomeModel model;
    private MyCollectContract.View view;

    public MyCollectPresenter() {
        model = new HomeModel();
    }


    @Override
    public void attach(MyCollectContract.View view) {
        this.view = view;
    }

    @Override
    public void getProgressBar() {
        if (view != null) {
            view.showProgressBar();
        }
    }

    @Override
    public void dismissProgressBar() {
        if (view != null) {
            view.dismissProgressBar();
        }
    }


    @Override
    public void getDbData() {
        if (view != null) {
            view.showListData(model.getDbData());
        }
    }

    @Override
    public void death() {
        view = null;
    }

}
