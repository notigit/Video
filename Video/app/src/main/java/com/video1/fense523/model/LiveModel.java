package com.video1.fense523.model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.video1.fense523.app.Consts;
import com.video1.fense523.utils.volley.RespCallback;

/**
 * Created by KingYang on 16/3/26.
 * E-Mail: admin@kingyang.cn
 */
public class LiveModel {
    private RequestQueue mQueue;

    public LiveModel(RequestQueue mQueue) {
        this.mQueue = mQueue;
    }

    public void getLives(RespCallback<String> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, String.format(Consts.URL.VIDEO_BY_CHANNEL, 100), callback, callback);
        mQueue.add(request);
    }
}
