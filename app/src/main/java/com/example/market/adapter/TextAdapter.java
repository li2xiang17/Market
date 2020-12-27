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
import com.example.market.R;

public class TextAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;

    public TextAdapter(Context context, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root= LayoutInflater.from(context).inflate(R.layout.text_item,parent,false);
        return new TextViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class TextViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        public TextViewHolder(View root) {
            super(root);
            text =root.findViewById(R.id.tv_text);
        }
    }
}
