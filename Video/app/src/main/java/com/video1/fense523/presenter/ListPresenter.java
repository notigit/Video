package com.video1.fense523.presenter;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.video1.fense523.bean.Video;
import com.video1.fense523.model.VideoModel;
import com.video1.fense523.ui.view.IListView;
import com.video1.fense523.utils.volley.RespCallback;

import java.util.List;

/**
 * Created by KingYang on 2016/4/29.
 * E-Mail: admin@kingyang.cn
 */
public class ListPresenter {
    private IListView view;
    private VideoModel videoModel;
    private Gson gson;
    public ListPresenter(IListView view, RequestQueue queue) {
        this.videoModel = new VideoModel(queue);
        this.view = view;
        gson = new Gson();
    }

    public void loadVideos(int cid,int page) {
        videoModel.getByChannel(cid, new RespCallback<String>() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                view.showError("连接服务器失败");
            }

            @Override
            public void onResponse(String s) {
                try {

                    List<Video> videos = gson.fromJson(s, new TypeToken<List<Video>>() {
                    }.getType());
                    view.showVideos(videos);
                } catch (Exception e) {
                    view.showError("解析数据出错");
                }
            }
        });
    }
}
