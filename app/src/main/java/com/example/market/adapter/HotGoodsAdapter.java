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
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import java.util.ArrayList;

public class HotGoodsAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotlist;
    private LinearLayoutHelper linearLayoutHelper;

    public HotGoodsAdapter(Context context, ArrayList<HomeBean.DataBean.HotGoodsListBean> hotlist, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.hotlist = hotlist;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.hot_item,parent,false);
        return new HotViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HotViewHolder hotViewHolder = (HotViewHolder) holder;
        HomeBean.DataBean.HotGoodsListBean bean = hotlist.get(position);
        hotViewHolder.brief.setText(bean.getGoods_brief());
        Glide.with(context).load(bean.getList_pic_url()).into(hotViewHolder.img);
        hotViewHolder.name.setText(bean.getName());
        hotViewHolder.price.setText("$ "+bean.getRetail_price()+"");
    }

    @Override
    public int getItemCount() {
        return hotlist.size();
    }

    private class HotViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView brief;
        TextView price;
        public HotViewHolder(View root) {
            super(root);
            img = root.findViewById(R.id.iv_img);
            name = root.findViewById(R.id.tv_name);
            brief = root.findViewById(R.id.tv_brief);
            price =root.findViewById(R.id.tv_price);
        }
    }
}
