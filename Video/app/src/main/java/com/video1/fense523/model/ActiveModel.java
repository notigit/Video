package com.video1.fense523.model;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.video1.fense523.app.Consts;
import com.video1.fense523.utils.volley.RespCallback;

/**
 * Created by KingYang on 2016/4/30.
 * E-Mail: admin@kingyang.cn
 */
public class ActiveModel {
    private RequestQueue queue;

    public ActiveModel(RequestQueue queue) {
        this.queue = queue;
    }

    public void activeVip(String code, RespCallback<String> callback) {
        StringRequest request = new StringRequest(Request.Method.GET, String.format(Consts.URL.ACTIVE_VIP, code), callback, callback);
        queue.add(request);
    }
}
