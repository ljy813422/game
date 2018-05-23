package com.xiaobai.game.mygame.httptest;

import android.content.Context;


/**
 * Created by lijingyin on 2017/12/4.
 */

public class NetWork {

    private static NetWork instatnce;

    private static YLApi ylApi;

    public NetWork(Context mContext) {
        ylApi = new YLApi(mContext);
    }

/*    public NetWork(Context mContext,boolean isTest) {
        ylApi = new YLApi(mContext,isTest);
    }*/
/*
    public static NetWork getTestInstance(Context mContext) {
        if (null == instatnce) {
            instatnce = new NetWork(mContext,true);
        }
        return instatnce;
    }
*/

    public static NetWork getInstance(Context mContext) {
        if (null == instatnce) {
            instatnce = new NetWork(mContext);
        }
        return instatnce;
    }

    public YLApi getYlApi() {
        return ylApi;
    }


}
