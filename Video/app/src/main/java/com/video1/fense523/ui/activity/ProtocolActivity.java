package com.video1.fense523.ui.activity;

import android.os.Bundle;

import com.video1.fense523.R;

public class ProtocolActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocol);
        setUpCommonBackTooblBar(R.id.toolbar, "用户协议");
    }

}
