package com.example.mvp.ui.module.home.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.mvp.R;
import com.example.mvp.base.BaseActivity;
import com.example.mvp.ui.module.home.fragment.MyCollectFragment;
import com.example.mvp.ui.module.home.fragment.MyListFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity {

    @BindView(R.id.btn_list)
    Button btnList;
    @BindView(R.id.btn_collect)
    Button btnCollect;
    @BindView(R.id.frame)
    FrameLayout frame;
    private MyListFragment listFragment;
    private MyCollectFragment collectFragment;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();

        transaction = fragmentManager.beginTransaction();
        listFragment = new MyListFragment();
        transaction.add(R.id.frame, listFragment).commit();
        btnList.setBackground(getResources().getDrawable(R.drawable.ch_btn_shape));
        btnCollect.setBackground(getResources().getDrawable(R.drawable.no_btn_shape));
    }


    @OnClick({R.id.btn_list, R.id.btn_collect})
    public void onViewClicked(View view) {
        transaction = fragmentManager.beginTransaction();
        hideAll(transaction);
        switch (view.getId()) {
            case R.id.btn_list:
                if (listFragment == null) {
                    listFragment = new MyListFragment();
                    transaction.add(R.id.frame, listFragment);
                } else {
                    transaction.show(listFragment);
                }
                btnList.setBackground(getResources().getDrawable(R.drawable.ch_btn_shape));
                btnCollect.setBackground(getResources().getDrawable(R.drawable.no_btn_shape));
                break;
            case R.id.btn_collect:
                if (collectFragment == null) {
                    collectFragment = new MyCollectFragment();
                    transaction.add(R.id.frame, collectFragment);
                } else {
                    transaction.show(collectFragment);
                }
                btnList.setBackground(getResources().getDrawable(R.drawable.no_btn_shape));
                btnCollect.setBackground(getResources().getDrawable(R.drawable.ch_btn_shape));
                break;
        }
        transaction.commit();
    }

    private void hideAll(FragmentTransaction transaction) {
        if (listFragment != null) {
            transaction.hide(listFragment);
        }
        if (collectFragment != null) {
            transaction.hide(collectFragment);
        }
    }

}
