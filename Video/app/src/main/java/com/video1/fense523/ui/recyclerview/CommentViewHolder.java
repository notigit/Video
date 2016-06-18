package com.video1.fense523.ui.recyclerview;

import android.view.View;
import android.widget.TextView;

import com.video1.fense523.R;
import com.video1.fense523.ui.adapter.BaseRecyclerAdapter;
import com.video1.fense523.ui.widget.CircleImageView;

/**
 * Created by KingYang on 2016/4/30.
 * E-Mail: admin@kingyang.cn
 */
public class CommentViewHolder extends BaseViewHolder {
    public CircleImageView avatar;
    public TextView username;
    public TextView replytime;
    public TextView content;

    public CommentViewHolder(View itemView, BaseRecyclerAdapter.OnItemClickListener listener) {
        super(itemView, listener);
        avatar = (CircleImageView) itemView.findViewById(R.id.avatar);
        username = (TextView) itemView.findViewById(R.id.username);
        replytime = (TextView) itemView.findViewById(R.id.replytime);
        content = (TextView) itemView.findViewById(R.id.content);
    }
}