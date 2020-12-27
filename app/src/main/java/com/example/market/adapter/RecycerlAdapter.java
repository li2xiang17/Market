package com.example.market.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import java.util.ArrayList;

public class RecycerlAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> list;

    public RecycerlAdapter(Context context, ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.recy_item,parent,false);
        return new HomeViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeViewHolder homeViewHolder = (HomeViewHolder) holder;
        HomeBean.DataBean.CategoryListBean.GoodsListBean bean = list.get(position);
        Glide.with(context).load(bean.getList_pic_url()).into(homeViewHolder.img);
        homeViewHolder.name.setText(bean.getName());
        homeViewHolder.price.setText("￥"+bean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        if (list.size()>0){
            return list.size();
        }else {
            return 0;
        }
    }

    private class HomeViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public HomeViewHolder(View root) {
            super(root);
            img = root.findViewById(R.id.iv_img);
            name = root.findViewById(R.id.tv_name);
            price = root.findViewById(R.id.tv_price);
        }
    }
}
