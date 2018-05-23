package com.xiaobai.game.mygame.http
import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.io.IOException

/**
 * http 拦截工具类
 * Created on 2018/5/14.
 * @author wr
 * @version 1.0.0
 */
object InterceptorUtil {
    val TAG = "InterceptorUtil"
    fun LogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            message -> Log.d(TAG,message)
        })
    }

    fun HeaderInterceptor(): Interceptor {
        return object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain.request()
                //在这里你可以做一些想做的事,比如token失效时,重新获取token
                //或者添加header等等,PS我会在下一篇文章总写拦截token方法
                return chain.proceed(request)
            }
        }
    }
}