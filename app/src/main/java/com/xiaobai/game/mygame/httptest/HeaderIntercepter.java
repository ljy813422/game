package com.xiaobai.game.mygame.httptest;

import android.content.Context;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lijingyin on 2017/12/14.
 */

public class HeaderIntercepter implements Interceptor {

    private Context context;
    private String imei;
    private String phoneVersion;


    public HeaderIntercepter(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();

//        builder.addHeader("IMEI", SystemUtil.getIMEI(context))
//                .addHeader("phonesystem", "android")
//                .addHeader("phonemodel", SystemUtil.getSystemModel());

        return chain.proceed(builder.build());
    }
}
