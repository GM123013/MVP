package com.example.mvp.ui.module.home.contract;

import android.view.View;

import com.example.mvp.base.BasePresenter;
import com.example.mvp.base.BaseView;
import com.example.mvp.model.callback.NetworkCallback;
import com.example.mvp.model.entity.InfoBean;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public interface MyListContract {

    interface View extends BaseView {
        void showData(List<InfoBean.StudentsBean.StudentBean> list);
        void btnClick(android.view.View view, int position);
    }
    interface Presenter extends BasePresenter<View> {
        void getListData();
    }
}
