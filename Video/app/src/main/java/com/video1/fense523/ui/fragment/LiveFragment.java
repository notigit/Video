package com.video1.fense523.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.video1.fense523.app.Consts;
import com.video1.fense523.bean.Video;
import com.video1.fense523.presenter.LivePresenter;
import com.video1.fense523.ui.activity.VideoPlayActivity;
import com.video1.fense523.ui.adapter.BaseRecyclerAdapter;
import com.video1.fense523.ui.adapter.LiveAdapter;
import com.video1.fense523.ui.view.ILiveView;
import com.video1.fense523.utils.SPUtil;
import com.video1.fense523.utils.ToastUtil;

import java.util.List;

public class LiveFragment extends RefreshableFragment implements ILiveView, BaseRecyclerAdapter.OnItemClickListener {
    private LiveAdapter adapter;
    private LivePresenter mPresenter;

    @Override
    public void onFragmentCreate() {
        adapter = new LiveAdapter(activity);
        adapter.setOnItemClickListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(activity, 2));
        mPresenter = new LivePresenter(this, activity.getQueue());
        refreshLayout.post(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(true);
                mPresenter.loadLives();
            }
        });
    }

    @Override
    public void showLives(List<Video> lives) {
        refreshLayout.setRefreshing(false);
        adapter.refreshData(lives);
    }


    @Override
    public void showError(String msg) {
        refreshLayout.setRefreshing(false);
        ToastUtil.show(activity, msg);
    }

    @Override
    public void onRefresh() {
        mPresenter.loadLives();
    }

    @Override
    public void onItemClick(View v, int position) {
        if (SPUtil.getInt(activity, Consts.SP.VIP) > 0) {
            String url = adapter.getItem(position).getUrl();
            startActivity(VideoPlayActivity.createIntent(activity, url, true));
        } else {
            activity.showPay1Dialog();
        }
    }
}
