package com.video1.fense523.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.video1.fense523.R;
import com.video1.fense523.bean.Video;
import com.video1.fense523.presenter.ListPresenter;
import com.video1.fense523.ui.adapter.BaseRecyclerAdapter;
import com.video1.fense523.ui.adapter.VideoAdapter;
import com.video1.fense523.ui.view.IListView;
import com.video1.fense523.utils.ToastUtil;

import java.util.List;

public class ListActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, IListView,BaseRecyclerAdapter.OnItemClickListener {
    private static final String CHANNEL_ID = "cid";
    private static final String CHANNEL_TITLE = "title";
    private SwipeRefreshLayout refreshLayout;
    private RecyclerView recyclerView;
    private VideoAdapter adapter;
    private ListPresenter presenter;
    private int cid;
    private int currentPage = 1;

    public static Intent createIntent(Context context, int id, String title) {
        Intent intent = new Intent(context, ListActivity.class);
        intent.putExtra(CHANNEL_ID, id);
        intent.putExtra(CHANNEL_TITLE, title);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        cid = intent.getIntExtra(CHANNEL_ID, 0);
        String title = intent.getStringExtra(CHANNEL_TITLE);
        setUpCommonBackTooblBar(R.id.toolbar, title);


        presenter = new ListPresenter(this, getQueue());
        adapter = new VideoAdapter(this);
        adapter.setOnItemClickListener(this);
        refreshLayout = (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
        refreshLayout.setColorSchemeResources(R.color.colorPrimary, android.R.color.holo_red_light, android.R.color.holo_green_light, android.R.color.holo_orange_light);
        refreshLayout.setOnRefreshListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        presenter.loadVideos(cid, currentPage);
    }

    @Override
    public void onRefresh() {
        presenter.loadVideos(cid, currentPage);
    }

    @Override
    public void showVideos(List<Video> videos) {
        refreshLayout.setRefreshing(false);
        adapter.refreshData(videos);
        currentPage++;
    }

    @Override
    public void showError(String msg) {
        ToastUtil.show(this, msg);
    }

    @Override
    public void onItemClick(View v, int position) {
        startActivity(VideoActivity.createIntent(this, adapter.getItem(position).getId()));
    }
}
