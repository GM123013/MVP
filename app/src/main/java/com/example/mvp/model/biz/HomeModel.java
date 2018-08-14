package com.example.mvp.model.biz;

import com.example.mvp.config.Constants;
import com.example.mvp.model.callback.NetworkCallback;
import com.example.mvp.model.db.DbFactroy;
import com.example.mvp.model.entity.InfoBean;
import com.example.mvp.model.entity.User;
import com.example.mvp.model.http.HttpFactory;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public class HomeModel implements IHomeModel {
    @Override
    public void getListData(NetworkCallback<InfoBean> callback) {
        HttpFactory.create().doGet(Constants.URL, callback);
    }

    @Override
    public List<User> getDbData() {
       return DbFactroy.create().loadAll();
    }

}
