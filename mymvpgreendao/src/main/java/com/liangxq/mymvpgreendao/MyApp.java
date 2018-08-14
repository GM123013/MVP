package com.liangxq.mymvpgreendao;

import android.app.Application;
import android.content.Context;

import com.liangxq.mymvpgreendao.bean.Student;
import com.liangxq.mymvpgreendao.dao.DabaseHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public class MyApp extends Application {

    public static MyApp myApp;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        List<Student>students=new ArrayList<>();
        for (int i = 0; i <50 ; i++) {
            students.add(new Student(null,"liangxq  "+i,+i+100));
        }
        DabaseHelper.getInstance().insertALL(students);
    }

    public static Context getInstance(){
        return myApp;
    }
}
