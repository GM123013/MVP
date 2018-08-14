package com.example.mvp.ui.module.home.presenter;

import android.os.Looper;

import com.example.mvp.model.biz.HomeModel;
import com.example.mvp.model.biz.IHomeModel;
import com.example.mvp.model.callback.NetworkCallback;
import com.example.mvp.model.entity.InfoBean;
import com.example.mvp.ui.module.home.contract.MyListContract;

/**
 * Created by GM on 2018/8/13.
 */

public class MyListPresenter implements MyListContract.Presenter {
    private IHomeModel model;
    private MyListContract.View view;

    public MyListPresenter() {
        model = new HomeModel();
    }

    @Override
    public void getListData() {
        model.getListData(new NetworkCallback<InfoBean>() {
            @Override
            public void onSuccess(InfoBean infoBean) {
                if (view != null) {
                    Looper.prepare();
                    view.showData(infoBean.getStudents().getStudent());
                    Looper.loop();
                }
            }

            @Override
            public void onError(String errorMsg) {

            }
        });
    }


    @Override
    public void attach(MyListContract.View view) {
        this.view = view;
    }

    @Override
    public void death() {
        view = null;
    }
}
