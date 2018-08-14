package com.liangxq.mymvpgreendao.dao;

import com.liangxq.mymvpgreendao.MyApp;
import com.liangxq.mymvpgreendao.bean.Student;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public class DabaseHelper {

    public static DabaseHelper dabaseHelper;
    private final StudentDao studentDao;

    private DabaseHelper() {
        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(MyApp.getInstance(), "liangxq.db");
        DaoMaster daoMaster = new DaoMaster(openHelper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        studentDao = daoSession.getStudentDao();
    }

    public static DabaseHelper getInstance() {
        if (dabaseHelper == null) {
            synchronized (DabaseHelper.class) {
                if (dabaseHelper == null) {
                    dabaseHelper = new DabaseHelper();
                }
            }

        }

        return dabaseHelper;
    }

    /**
     * 插入方法
     * @param students
     */
    public void insertALL(List<Student>students){
        studentDao.insertInTx(students);

    }

    /**
     * 查询
     * @return
     */
    public List<Student>  selectAll(){
        return studentDao.queryBuilder().list();
    }

}
