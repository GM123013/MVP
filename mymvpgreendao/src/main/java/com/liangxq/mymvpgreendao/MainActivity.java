package com.liangxq.mymvpgreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.liangxq.mymvpgreendao.bean.Student;
import com.liangxq.mymvpgreendao.module.MainModuleIml;
import com.liangxq.mymvpgreendao.presenter.MainPresenter;
import com.liangxq.mymvpgreendao.presenter.MainPresenterIml;
import com.liangxq.mymvpgreendao.view.MainView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView{

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        recyclerView=findViewById(R.id.recyclerview);
        progressBar=findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //创建控制层对象
        MainPresenter mainPresenter=new MainPresenterIml(new MainModuleIml(),this);
        //调用关联方法
        mainPresenter.setUIData();
    }

    @Override
    public void showProgessBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgessBar() {
        progressBar.setVisibility(View.GONE);
    }

    /**
     * 设置数据显示视图
     * @param students
     */
    @Override
    public void showData(List<Student> students) {
       recyclerView.setAdapter(new MyAdapter(students,this));
    }
}
