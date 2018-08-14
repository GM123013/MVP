package com.example.mvp.model.db;

import com.example.mvp.app.App;
import com.example.mvp.model.entity.User;

import java.time.temporal.ValueRange;
import java.util.List;

import retrofit2.http.Url;

/**
 * Created by GM on 2018/8/13.
 */

public class DbUtils {
    private static DbUtils dbUtils;
    private UserDao userDao;

    private DbUtils() {
        userDao = App.getDaoSession().getUserDao();
    }

    public static DbUtils getInstance() {
        if (dbUtils == null) {
            synchronized (DbUtils.class) {
                if (dbUtils == null) {
                    dbUtils = new DbUtils();
                }
            }
        }
        return dbUtils;
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public User load(Long key) {
        return userDao.load(key);
    }

    public List<User> loadAll() {
        return userDao.loadAll();
    }

    public void delete(User user) {
        userDao.delete(user);
    }

    public void delete(Long key) {
        userDao.deleteByKey(key);
    }

    public void update(User user) {
        userDao.update(user);
    }

}
