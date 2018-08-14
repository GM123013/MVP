package com.example.mvp.ui.module.home.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mvp.R;
import com.example.mvp.base.BaseFragment;
import com.example.mvp.base.BaseView;
import com.example.mvp.model.db.DbFactroy;
import com.example.mvp.model.entity.InfoBean;
import com.example.mvp.model.entity.User;
import com.example.mvp.ui.module.home.adapter.MyListAdapter;
import com.example.mvp.ui.module.home.contract.MyListContract;
import com.example.mvp.ui.module.home.presenter.MyCollectPresenter;
import com.example.mvp.ui.module.home.presenter.MyListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyListFragment extends BaseFragment implements MyListContract.View {

    @BindView(R.id.rl)
    RecyclerView rl;
    Unbinder unbinder;
    private MyListAdapter adapter;
    private List<InfoBean.StudentsBean.StudentBean> list;
    private MyListPresenter listPresenter;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my_list;
    }

    @Override
    protected void initView(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);

        listPresenter = new MyListPresenter();
        listPresenter.attach(this);
        listPresenter.getListData();
    }

    @Override
    public void showData(List<InfoBean.StudentsBean.StudentBean> list) {
        this.list = list;
        adapter = new MyListAdapter(R.layout.item_list_layout, list, getActivity());
        rl.setAdapter(adapter);
        rl.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                btnClick(view, position);
            }
        });
    }

    /**
     * 点击收藏
     */
    @Override
    public void btnClick(View view, int position) {
        InfoBean.StudentsBean.StudentBean studentBean = list.get(position);
        DbFactroy.create().insert(new User(null, studentBean.getName(), studentBean.getContent(), studentBean.getImg()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        listPresenter.death();
    }
}
