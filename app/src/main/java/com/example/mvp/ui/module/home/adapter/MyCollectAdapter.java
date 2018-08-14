package com.example.mvp.ui.module.home.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mvp.R;
import com.example.mvp.model.entity.User;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by GM on 2018/8/13.
 */

public class MyCollectAdapter extends BaseQuickAdapter<User,BaseViewHolder> {
    private Context context;

    public MyCollectAdapter(int layoutResId, @Nullable List<User> data, Context context) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, User item) {
        Picasso.with(context).load(item.getImg()).into((ImageView) helper.getView(R.id.img));

        helper.setText(R.id.title, item.getName())
                .setText(R.id.content, item.getContent());
    }
}
