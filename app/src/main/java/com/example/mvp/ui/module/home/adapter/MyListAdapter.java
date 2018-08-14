package com.example.mvp.ui.module.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvp.R;
import com.example.mvp.model.entity.InfoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public class MyListAdapter extends BaseQuickAdapter<InfoBean.StudentsBean.StudentBean, BaseViewHolder> {

    private Context context;

    public MyListAdapter(int layoutResId, @Nullable List<InfoBean.StudentsBean.StudentBean> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, InfoBean.StudentsBean.StudentBean item) {
        Picasso.with(context).load(item.getImg()).into((ImageView) helper.getView(R.id.img));

        helper.setText(R.id.title, item.getName())
                .setText(R.id.content, item.getContent())
                .addOnClickListener(R.id.btn);
    }
}
