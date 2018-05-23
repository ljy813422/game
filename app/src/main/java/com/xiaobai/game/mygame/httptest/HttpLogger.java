package com.xiaobai.game.mygame.httptest;

import android.util.Log;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by lijingyin on 2017/12/14.
 */

public class HttpLogger implements HttpLoggingInterceptor.Logger {
    @Override
    public void log(String message) {
        Log.d("HttpLogInfo", message);
    }
}
