package com.video1.fense523.app;

import android.app.Application;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.video1.fense523.utils.AppUtil;
import com.video1.fense523.utils.SPUtil;

/**
 * Created by KingYang on 16/4/14.
 * E-Mail: admin@kingyang.cn
 */
public class App extends Application {
    private RequestQueue queue;// 请求队列
    private ImageLoader imageLoader;// 图片异步加载器

    public RequestQueue getQueue() {
        return queue;
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // 网络通信相关
        queue = Volley.newRequestQueue(this);
        imageLoader = new ImageLoader(queue, new MyImageCache());
        // 生成UID
        if (TextUtils.isEmpty(SPUtil.getString(getApplicationContext(), Consts.SP.UID))) {
            SPUtil.putString(getApplicationContext(), Consts.SP.UID, AppUtil.createUid(getApplicationContext()));
        }
    }

    private class MyImageCache implements ImageLoader.ImageCache {
        private LruCache<String, Bitmap> mImageCache;

        public MyImageCache() {
            int maxSize = 10 * 1024 * 1024;// 缓存大小:10MB
            mImageCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap value) {
                    return value.getRowBytes() * value.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String s) {
            return mImageCache.get(s);
        }

        @Override
        public void putBitmap(String s, Bitmap bitmap) {
            mImageCache.put(s, bitmap);
        }
    }
}
