package com.xiaobai.game.mygame.httptest;

import android.content.Context;


import org.reactivestreams.Subscription;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lijingyin on 2017/12/4.
 */

public abstract class RetrofitUtils {

    //服务器路径

    protected static Retrofit mRetrofit;
    protected static OkHttpClient mOkHttpClient;


    /**
     * 获取Retrofit对象
     *
     * @return
     */
    protected static Retrofit getRetrofit(Context mContext) {

        if (null == mRetrofit) {

            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient(mContext);
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Interface.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();

        }

        return mRetrofit;
    }


/*    *//**
     * 获取Retrofit对象
     *
     * @return
     *//*
    protected static Retrofit getRetrofitTest(Context mContext) {

        if (null == mRetrofit) {

            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttp3Utils.getOkHttpClient(mContext);
            }
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Interface.BASEURL1)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(mOkHttpClient)
                    .build();

        }

        return mRetrofit;
    }*/


    /**
     *  不可取消订阅
     * created at 2018/5/18
     * params
     */
    public static <T> void setSubscribe(Observable<T> observable, Observer<T> observer) {
        observable.subscribeOn(Schedulers.io())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
    }

/*    *//**
     *  可取消订阅
     * created at 2018/5/18
     * params
     *//*
    static <T> Subscription setSubscribeCancel(Observable<T> observable, Observer<T> observer) {
         observable.subscribeOn(Schedulers.io())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer);
        return
    }*/




//    public static <T> void setSubscribe(Observable<T> observable, Action1<T> action1) {
//        observable.subscribeOn(Schedulers.io())
//                .subscribeOn(Schedulers.io())//子线程访问网络
//                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
//                .subscribe(action1);
//    }

}
