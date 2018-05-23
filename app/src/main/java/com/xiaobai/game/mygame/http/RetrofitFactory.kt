package com.xiaobai.game.mygame.http
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

import java.util.concurrent.TimeUnit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created on 2018/5/15.
 *
 * @author wr
 * @version 1.0.0
 */

open class RetrofitFactory {
    fun getRetrofit(): Retrofit {
        val mOkHttpClient = OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_CONNECT_TIME.toLong(), TimeUnit.SECONDS)
                .readTimeout(HttpConfig.HTTP_READ_TIME.toLong(), TimeUnit.SECONDS)
                .writeTimeout(HttpConfig.HTTP_WRITE_TIME.toLong(), TimeUnit.SECONDS)
                .addInterceptor(InterceptorUtil.HeaderInterceptor())
                .addInterceptor(InterceptorUtil.LogInterceptor())//添加日志拦截器
                .build()

        return Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(mOkHttpClient)
                .build()
    }

    fun <T> setSubscribe(observable: Observable<T>, observer: Observer<T>) {
        observable.subscribeOn(Schedulers.io())//子线程访问网络
                .observeOn(AndroidSchedulers.mainThread())//回调到主线程
                .subscribe(observer)
    }


}
