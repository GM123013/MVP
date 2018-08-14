package com.example.mvp.model.db;

/**
 * Created by GM on 2018/8/13.
 */

public class DbFactroy {
    public static DbUtils create() {
        return DbUtils.getInstance();
    }
}
