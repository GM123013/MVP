package com.liangxq.mymvpgreendao.module;

import com.liangxq.mymvpgreendao.bean.Student;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public interface MainModule {
    /**
     * 内部接口的形式回调数据
     */
    interface FinfihDatabase{
        /**
         * 回传数据
         * @param students
         */
        void getDataList(List<Student>students);

        void setShowProgressBar();

        void setHodeProgressBar();
    }

    /**
     * 获取数据
     */
    void  getData(FinfihDatabase finfihDatabase);
}
