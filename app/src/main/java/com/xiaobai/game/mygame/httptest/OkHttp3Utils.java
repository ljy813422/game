package com.xiaobai.game.mygame.httptest;

import android.content.Context;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by lijingyin on 2017/12/4.
 */

public class OkHttp3Utils {

    private static OkHttpClient mOkHttpClient;

    //设置缓存目录
    private static File cacheDirectory;
    private static Cache cache;


    /**
     * 获取OkHttpClient对象
     *
     * @return
     */
    public static OkHttpClient getOkHttpClient(Context mContext) {

        if (null == cacheDirectory) {
            cacheDirectory = new File(mContext.getCacheDir().getAbsolutePath(), "MyCache");
            cache = new Cache(cacheDirectory, 10 * 1024 * 1024);
        }

        if (mOkHttpClient == null) {

            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);


            mOkHttpClient = new OkHttpClient.Builder()
//                    .cookieJar(new CookiesManager())
//                    .addInterceptor(new NetIntercepter(mContext))
                    .addInterceptor(new HeaderIntercepter(mContext))
//                    .addInterceptor(new SignInterceptor())
//                    .addInterceptor(new UrlInterceptor())
//                    .addNetworkInterceptor(new CookiesInterceptor(MyApplication.getInstance().getApplicationContext()))
                    .addNetworkInterceptor(logInterceptor)
                    //设置请求读写的超时时间
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .build();
        }
        return mOkHttpClient;

    }
}

