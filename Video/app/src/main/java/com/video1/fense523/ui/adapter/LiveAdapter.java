package com.video1.fense523.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;
import com.video1.fense523.R;
import com.video1.fense523.bean.Video;
import com.video1.fense523.ui.activity.BaseActivity;
import com.video1.fense523.ui.recyclerview.LiveViewHolder;

/**
 * Created by KingYang on 16/3/15.
 * E-Mail: admin@kingyang.cn
 */
public class LiveAdapter extends BaseRecyclerAdapter<Video, LiveViewHolder> {

    public LiveAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public LiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_live, parent, false);
        return new LiveViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(LiveViewHolder holder, int position) {
        Video video = getItem(position);
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(holder.face, R.mipmap.video_loading, R.mipmap.video_loading);
        activity.getImageLoader().get(video.getFace(), listener);
    }

}


