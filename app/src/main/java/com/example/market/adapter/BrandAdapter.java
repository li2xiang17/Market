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
import java.util.List;

public class BrandAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandlist;
    private GridLayoutHelper gridLayoutHelper;

    public BrandAdapter(Context context, ArrayList<HomeBean.DataBean.BrandListBean> brandlist, GridLayoutHelper gridLayoutHelper) {
        this.context = context;
        this.brandlist = brandlist;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.brand_item,parent,false);
        return new BrandViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BrandViewHolder brandViewHolder = (BrandViewHolder) holder;
        HomeBean.DataBean.BrandListBean bean = brandlist.get(position);
        brandViewHolder.name.setText(bean.getName());
        brandViewHolder.pice.setText(bean.getFloor_price()+"");
        Glide.with(context).load(bean.getNew_pic_url()).into(brandViewHolder.img);
    }

    @Override
    public int getItemCount() {
        return brandlist.size();
    }

    private class BrandViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;
        TextView pice;
        public BrandViewHolder(View root) {
            super(root);
            img = root.findViewById(R.id.iv_img);
            name = root.findViewById(R.id.tv_name);
            pice = root.findViewById(R.id.tv_pice);
        }
    }
}
