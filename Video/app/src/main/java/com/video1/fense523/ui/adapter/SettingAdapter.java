package com.video1.fense523.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.video1.fense523.R;
import com.video1.fense523.bean.Setting;
import com.video1.fense523.ui.activity.BaseActivity;
import com.video1.fense523.ui.recyclerview.SettingViewHolder;

/**
 * Created by KingYang on 2016/4/24.
 * E-Mail: admin@kingyang.cn
 */
public class SettingAdapter extends BaseRecyclerAdapter<Setting, SettingViewHolder> {

    public SettingAdapter(BaseActivity activity) {
        super(activity);
    }

    @Override
    public SettingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_setting, parent, false);
        return new SettingViewHolder(view, activity, listener);
    }

    @Override
    public void onBindViewHolder(SettingViewHolder holder, int position) {
        Setting setting = getItem(position);
        holder.icon.setImageResource(setting.getIcon());
        holder.title.setText(setting.getTitle());
        holder.value.setText(setting.getValue());
        if (setting.isBlank()) {
            holder.setBlank();
        }
    }

}

