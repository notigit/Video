package com.video1.fense523.ui.view;

import com.video1.fense523.bean.Comment;
import com.video1.fense523.bean.Video;

import java.util.List;

/**
 * Created by KingYang on 16/3/25.
 * E-Mail: admin@kingyang.cn
 */
public interface IVideoView {
    void showVideoAndComments(Video videos,List<Comment> comments);
    void showError(String msg);
}
