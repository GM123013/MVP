package com.liangxq.mymvpgreendao.view;

import com.liangxq.mymvpgreendao.bean.Student;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public interface MainView {

    void showProgessBar();
    void hideProgessBar();

    /**
     * 接受数据方法
     * @param students
     */
    void showData(List<Student>students);
}
