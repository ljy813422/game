package com.xiaobai.game.mygame.http
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created on 2018/5/15.
 *
 * @author wr
 * @version 1.0.0
 */

 interface APIFunction {
/*    @GET(URLConfig.BAIDUURL)
    fun getBaidu(@Query("nick") name: String): Observable<BaseEntity<Any>>

    @GET(URLConfig.ADLIST)
    fun getBaiduPath(): Observable<BaseEntity<Any>>*/

    @GET(URLConfig.SHOW)
    fun getShow(): Observable<BaseEntity<Any>>
}
