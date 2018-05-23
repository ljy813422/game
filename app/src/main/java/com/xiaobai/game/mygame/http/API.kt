package com.xiaobai.game.mygame.http
import io.reactivex.Observer

/**
 * Created on 2018/5/15.
 *
 * @author wr
 * @version 1.0.0
 */

open class API : RetrofitFactory() {

    private val apiFunction: APIFunction = getRetrofit().create(APIFunction::class.java)

  /*  internal fun getBaidu(name: String, observer: Observer<BaseEntity<Any>>) {
        setSubscribe(apiFunction.getBaidu(name), observer)
    }
    internal fun getBaiduPath(tn: String, observer: Observer<BaseEntity<Any>>) {
        setSubscribe(apiFunction.getBaiduPath(), observer)
    }*/
    fun getShow( observer: Observer<BaseEntity<Any>>) {
        setSubscribe(apiFunction.getShow(), observer)
    }
}
