package com.example.mvp.model.biz;

import com.example.mvp.model.callback.NetworkCallback;
import com.example.mvp.model.entity.InfoBean;
import com.example.mvp.model.entity.User;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public interface IHomeModel {
    void getListData(NetworkCallback<InfoBean> callback);

    List<User> getDbData();
}
