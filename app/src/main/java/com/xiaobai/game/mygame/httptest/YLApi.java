package com.xiaobai.game.mygame.httptest;

import android.content.Context;

import org.reactivestreams.Subscription;

import io.reactivex.Observer;

/**
 *  API 请求类
 * Created by lijingyin on 2017/12/14
 */
public class YLApi extends RetrofitUtils {

    //创建实现接口调用
    private YlService service;


    YLApi(Context context) {
        service = getRetrofit(context).create(YlService.class);
    }

/*
    public YLApi(Context context,boolean isTest) {
        service = getRetrofitTest(context).create(YlService.class);
    }
*/


   /* //POST请求
    public void delPreference(String token, Map<String, String> map, Observer<PublicBean> observer) {
        setSubscribe(service.delPreference(token, map), observer);
    }


    //POST请求 反馈
    public void feedback(String token, Map<String, RequestBody> map, Observer<PublicBean> observer) {
        setSubscribe(service.feedback(token, map), observer);
    }

    //POST请求 发票申请提交
    public void applyInvoice(String token, Map<String, String> map, Observer<PublicBean> observer) {
        setSubscribe(service.applyInvoice(token, map), observer);
    }
    //POST请求 用户信息收集
    public Subscription userSaveBehavior(Map<String, String> map, Observer<PublicBean> observer) {
        return setSubscribeCancel(service.userSaveBehavior(map), observer);
    }*/

    //POST请求 用户信息收集
    public void userSaveBehavior(Observer<Object> observer) {
        setSubscribe(service.getShowInfo(), observer);
    }
}
