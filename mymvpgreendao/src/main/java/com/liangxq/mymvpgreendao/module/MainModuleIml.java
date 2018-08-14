package com.liangxq.mymvpgreendao.module;

import android.os.Handler;

import com.liangxq.mymvpgreendao.bean.Student;
import com.liangxq.mymvpgreendao.dao.DabaseHelper;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public class MainModuleIml implements MainModule {
    @Override
    public void getData(final FinfihDatabase finfihDatabase) {
        //请求数据前调用显示方法用于显示View层的进度条
        finfihDatabase.setShowProgressBar();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Student> lists=DabaseHelper.getInstance().selectAll();
                finfihDatabase.getDataList(lists);
                //请求数据后调用隐藏方法用于隐藏View层的进度条
                finfihDatabase.setHodeProgressBar();
            }
        },2000);

    }
}
