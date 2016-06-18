package com.video1.fense523.ui.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.video1.fense523.R;
import com.video1.fense523.ui.adapter.BaseRecyclerAdapter;

/**
 * Created by KingYang on 2016/4/29.
 * E-Mail: admin@kingyang.cn
 */
public class VideoViewHolder extends BaseViewHolder {
    public ImageView image;
    public ImageView flag;
    public TextView title;

    public VideoViewHolder(View itemView, final BaseRecyclerAdapter.OnItemClickListener listener) {
        super(itemView, listener);
        image = (ImageView) itemView.findViewById(R.id.image);
        flag = (ImageView) itemView.findViewById(R.id.flag);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}