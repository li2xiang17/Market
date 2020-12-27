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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.market.R;
import com.example.market.bean.HomeBean;


import java.util.List;

public class ThirdAdapter extends DelegateAdapter.Adapter<ThirdAdapter.ViewHolder> {
    private Context mContext;
    private ColumnLayoutHelper columnLayoutHelper;
    private List<HomeBean.DataBean.ChannelBean> mData;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public ThirdAdapter(Context mContext, ColumnLayoutHelper columnLayoutHelper, List<HomeBean.DataBean.ChannelBean> mData) {
        this.mContext = mContext;
        this.columnLayoutHelper = columnLayoutHelper;
        this.mData = mData;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public ThirdAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_third, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThirdAdapter.ViewHolder holder, int position) {
        Glide.with(mContext).load(mData.get(position).getIcon_url()).into(holder.ivthirdimg);
        holder.tvthirdtitle.setText(mData.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivthirdimg;
        private TextView tvthirdtitle;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivthirdimg = itemView.findViewById(R.id.iv_third_img);
            tvthirdtitle = itemView.findViewById(R.id.tv_third_title);
        }
    }


    public interface OnClickListener{
        void onClick(int position);
    }
}
