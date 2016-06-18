package com.video1.fense523.model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.video1.fense523.app.Consts;
import com.video1.fense523.utils.volley.RespCallback;

/**
 * Created by KingYang on 16/3/23.
 * E-Mail: admin@kingyang.cn
 */
public class VideoModel {
    private RequestQueue queue;

    public VideoModel(RequestQueue queue) {
        this.queue = queue;
    }


    public void getByChannel(int cid, RespCallback callback) {
        getVideos(String.format(Consts.URL.VIDEO_BY_CHANNEL, cid), callback);
    }

    public void getHomeData( RespCallback<String> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, Consts.URL.VIDEO_HOME, callback, callback);
        queue.add(request);
    }

    private void getVideos(String url, RespCallback<String> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, url, callback, callback);
        queue.add(request);
    }

    public void getVideoInfo(int vid, RespCallback<String> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, String.format(Consts.URL.VIDEO_BY_ID, vid), callback, callback);
        queue.add(request);
    }

}
