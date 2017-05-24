package com.team.finn.view.home.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.team.finn.R;
import com.team.finn.model.logic.home.bean.HomeHotColumn;
import com.team.finn.utils.CalculationUtils;
import com.team.finn.view.common.activity.PcLiveVideoActivity;
import com.team.finn.view.common.activity.PhoneLiveVideoActivity;

import java.util.List;

/**
 *  最热栏目
 *
 */
public class HomeRecommendHotColumnAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<HomeHotColumn> mHomeHotColumn;
    private  Context context;

    public HomeRecommendHotColumnAdapter(Context context, List<HomeHotColumn> mHomeHotColumn)
    {
          this.context=context;
          this.mHomeHotColumn=mHomeHotColumn;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HotColumnHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_recommend_view,parent,false));
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if(holder instanceof HotColumnHolder)
            {
                bindHotColumun((HotColumnHolder) holder,position);
            }
    }
    private void bindHotColumun(HotColumnHolder holder, int position) {
         holder.img_item_gridview.setImageURI(Uri.parse(mHomeHotColumn.get(position).getVertical_src()));
         holder.tv_column_item_nickname.setText(mHomeHotColumn.get(position).getRoom_name());
         holder.tv_nickname.setText(mHomeHotColumn.get(position).getNickname());
        holder.tv_online_num.setText(CalculationUtils.getOnLine(mHomeHotColumn.get(position).getOnline()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PcLiveVideoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Room_id",mHomeHotColumn.get(position).getRoom_id());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mHomeHotColumn.size();
    }
    public class HotColumnHolder extends  BaseViewHolder
    {
//        图片
        public  SimpleDraweeView  img_item_gridview;
//        房间名称
        public TextView tv_column_item_nickname;
//        在线人数
        public TextView tv_online_num;
//        昵称
        public TextView tv_nickname;

        public HotColumnHolder(View view) {
            super(view);
            img_item_gridview=(SimpleDraweeView)view.findViewById(R.id.img_item_gridview);
            tv_column_item_nickname=(TextView)view.findViewById(R.id.tv_column_item_nickname);
            tv_online_num=(TextView)view.findViewById(R.id.tv_online_num);
            tv_nickname=(TextView)view.findViewById(R.id.tv_nickname);
        }
    }
}
