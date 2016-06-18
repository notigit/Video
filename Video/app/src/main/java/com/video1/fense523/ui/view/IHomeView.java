package com.video1.fense523.ui.view;

import com.video1.fense523.bean.Video;

import java.util.List;

/**
 * Created by yangking on 16/3/23.
 */
public interface IHomeView {
    void showHomeData(List<Video> banner, List<Video> videos);

    void showError(String msg);
}
