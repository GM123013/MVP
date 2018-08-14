package com.liangxq.mymvpgreendao.presenter;

import com.liangxq.mymvpgreendao.bean.Student;
import com.liangxq.mymvpgreendao.module.MainModule;
import com.liangxq.mymvpgreendao.view.MainView;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public class MainPresenterIml implements MainPresenter, MainModule.FinfihDatabase {

    private MainModule mainModule;

    private MainView mainView;

    public MainPresenterIml(MainModule mainModule, MainView mainView) {
        this.mainModule = mainModule;
        this.mainView = mainView;
    }

    /**
     * 关联View层和module层
     */
    @Override
    public void setUIData() {
        if(mainView!=null){
            mainModule.getData(this);
        }

    }

    /**
     * 回调数据给View层
     * @param students
     */
    @Override
    public void getDataList(List<Student> students) {
        if(mainView!=null){
            mainView.showData(students);
        }
    }

    /**
     * 设置进度条的显示调用View层的方法
     */
    @Override
    public void setShowProgressBar() {
       if(mainView!=null){
           mainView.showProgessBar();
       }
    }

    /**
     *  设置进度条的隐藏调用View层的方法
     */
    @Override
    public void setHodeProgressBar() {
        if(mainView!=null){
            mainView.hideProgessBar();
        }
    }
}
