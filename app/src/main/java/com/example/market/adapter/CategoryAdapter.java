package com.example.market.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends DelegateAdapter.Adapter{
    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean> list;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;
    private RecycerlAdapter recycerlAdapter;

    public CategoryAdapter(Context context, ArrayList<HomeBean.DataBean.CategoryListBean> list, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.list = list;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
            return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new RecyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyViewHolder recyViewHolder = (RecyViewHolder) holder;
        HomeBean.DataBean.CategoryListBean categoryListBean = list.get(position);
        recyViewHolder.name.setText(categoryListBean.getName());
        goodsListBeans = new ArrayList<>();
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        goodsListBeans.addAll(goodsList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        recyViewHolder.recycler.setLayoutManager(gridLayoutManager);
        recycerlAdapter = new RecycerlAdapter(context, goodsListBeans);
        recyViewHolder.recycler.setAdapter(recycerlAdapter);

    }

    @Override
    public int getItemCount() {
        if (list.size()>0){
            return list.size();
        }else {
            return 0;
        }
    }

    private class RecyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private RecyclerView recycler;
        public RecyViewHolder(View root) {
            super(root);
            name = root.findViewById(R.id.tv_home);
            recycler = root.findViewById(R.id.recycler);
        }
    }
}
