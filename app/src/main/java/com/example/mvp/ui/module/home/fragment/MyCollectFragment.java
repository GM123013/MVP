package com.example.mvp.ui.module.home.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.mvp.R;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.model.entity.User;
import com.example.mvp.ui.module.home.adapter.MyCollectAdapter;
import com.example.mvp.ui.module.home.contract.MyCollectContract;
import com.example.mvp.ui.module.home.presenter.MyCollectPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCollectFragment extends BaseFragment implements MyCollectContract.View {

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.rl)
    RecyclerView rl;
    Unbinder unbinder;
    private MyCollectPresenter collectPresenter;
    private MyCollectAdapter adapter;
    private static boolean flag = false;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x001) {
                if (progressBar.getProgress() < 100) {
                    progressBar.setProgress(progressBar.getProgress() + 10);
                    handler.sendEmptyMessageDelayed(0x001, 1000);
                } else {
                    collectPresenter.dismissProgressBar();
                }
            }
        }
    };

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (flag && !hidden) {
            progressBar.setProgress(0);
            collectPresenter.getProgressBar();
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_collect;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        collectPresenter = new MyCollectPresenter();
        collectPresenter.attach(this);
        collectPresenter.getProgressBar();
        flag = true;
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_my_collect, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        initView(view, savedInstanceState);
//
//    }


    @Override
    public void showProgressBar() {
        rl.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        handler.sendEmptyMessage(0x001);
    }

    @Override
    public void dismissProgressBar() {
        progressBar.setVisibility(View.GONE);
        rl.setVisibility(View.VISIBLE);
        collectPresenter.getDbData();
    }

    @Override
    public void showListData(List<User> list) {
        adapter = new MyCollectAdapter(R.layout.item_collect_layout, list, getActivity());
        rl.setAdapter(adapter);
        rl.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        collectPresenter.death();
    }


}
