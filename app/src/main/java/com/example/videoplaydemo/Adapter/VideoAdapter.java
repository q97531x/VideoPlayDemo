package com.example.videoplaydemo.Adapter;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.videoplaydemo.Bean.VideoData;
import com.example.videoplaydemo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by XmacZone on 16/10/12.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.MyVideoHolder> {
    private List<VideoData> list;
    private Context context;
    public VideoAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<VideoData> list){
        this.list = list;
    }
    @Override
    public MyVideoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.video_item,parent,false);
        return new MyVideoHolder(view);
    }

    @Override
    public void onBindViewHolder(MyVideoHolder holder, int position) {
        Glide.with(context).load(list.get(position).getCover()).into(holder.video_cover);
        holder.video_title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyVideoHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.video_item_image)
        ImageView video_cover;
        @Bind(R.id.video_play_image)
        ImageView video_play;
        @Bind(R.id.video_title)
        TextView video_title;
        public MyVideoHolder(View itemView) {
            super(itemView);
            //设置宽高比为16:9
            WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            int height = (int)(width*1.0f/16*9+0.5f);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams)itemView.getLayoutParams();
            params.width = width;
            params.height = height;
            itemView.setLayoutParams(params);
            ButterKnife.bind(this,itemView);
        }
    }

}
