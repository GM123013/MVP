package com.liangxq.mymvpgreendao;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liangxq.mymvpgreendao.bean.Student;

import java.util.List;

/**
 * Created by liangxq on 2018/7/13.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHodler> {

    private List<Student> lists;
    private Context context;
    private LayoutInflater layoutInflater;

    public MyAdapter(List<Student> lists, Context context) {
        this.lists = lists;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_layout, null);
        return new MyViewHodler(view);
    }

    @Override
    public void onBindViewHolder(MyViewHodler holder, int position) {
        holder.textView.setText(lists.get(position).getName());
        holder.textView2.setText(lists.get(position).getAge() + "");
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    static class MyViewHodler extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView2;

        public MyViewHodler(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
