package com.example.market.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.bumptech.glide.Glide;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import java.util.ArrayList;

public class TopAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> list;

    public TopAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.tops_item,parent,false);
        return new TopsViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopsViewHolder topsViewHolder = (TopsViewHolder) holder;
        HomeBean.DataBean.TopicListBean bean = list.get(position);
        Glide.with(context).load(bean.getItem_pic_url()).into(topsViewHolder.img);
        topsViewHolder.title.setText(bean.getTitle());
        topsViewHolder.price.setText("$"+bean.getPrice_info()+"元起");
        topsViewHolder.subtitle.setText(bean.getSubtitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private class TopsViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView title;
        TextView price;
        TextView subtitle;
        public TopsViewHolder(View root) {
            super(root);
            img= root.findViewById(R.id.iv_img);
            title = root.findViewById(R.id.tv_title);
            price = root.findViewById(R.id.tv_price);
            subtitle = root.findViewById(R.id.tv_subtitle);
        }
    }
}
