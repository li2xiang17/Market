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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import java.util.ArrayList;

public class NewGoodsAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodslist;
    private GridLayoutHelper gridLayoutHelper;

    public NewGoodsAdapter(Context context, ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodslist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.newGoodslist = newGoodslist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.goods_item,parent, false);
        return new  GoodsViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        GoodsViewHolder goodsViewHolder = (GoodsViewHolder) holder;
        HomeBean.DataBean.NewGoodsListBean bean = newGoodslist.get(position);
        goodsViewHolder.name.setText(bean.getName());
        goodsViewHolder.price.setText("￥ "+bean.getRetail_price()+"");
        Glide.with(context).load(bean.getList_pic_url()).into(goodsViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return newGoodslist.size();
    }

    private class GoodsViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView price;
        public GoodsViewHolder(View root) {
            super(root);
            img = root.findViewById(R.id.iv_img);
            name =root.findViewById(R.id.tv_name);
            price = root.findViewById(R.id.tv_price);
        }
    }
}
