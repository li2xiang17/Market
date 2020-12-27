package com.example.market.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.market.R;
import com.example.market.bean.HomeBean;

import java.util.ArrayList;

public class SpecialimgAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> toplist;
    private SingleLayoutHelper singleLayoutHelper;

    public SpecialimgAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> toplist, SingleLayoutHelper singleLayoutHelper) {
        this.context = context;
        this.toplist = toplist;
        this.singleLayoutHelper = singleLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return singleLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.top_item,parent, false);
        return new TopViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TopViewHolder topViewHolder = (TopViewHolder) holder;
        RecyclerView recyclerView = topViewHolder.recyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        TopAdapter topAdapter = new TopAdapter(context,toplist);
        recyclerView.setAdapter(topAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class TopViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public TopViewHolder(View root) {
            super(root);
            recyclerView = root.findViewById(R.id.recycler);
        }
    }
}
