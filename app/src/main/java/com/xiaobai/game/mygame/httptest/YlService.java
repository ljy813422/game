package com.xiaobai.game.mygame.httptest;


import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *  API 接口服务类
 *  Created by lijingyin on 2018/4/8.
 */

public interface YlService {

 /*   //删除偏好设置
    @POST(Interface.DEL_PREFERENCE)
    Observable<PublicBean> delPreference(@Header("token") String token, @QueryMap Map<String, String> map);

    //反馈
    @Multipart
    @POST(Interface.STATIONFEEDBACK)
    Observable<PublicBean> feedback(@Header("token") String token, @PartMap Map<String, RequestBody> map);

    //发票申请提交
    @POST(Interface.INVOICEAPPLY)
    Observable<PublicBean> applyInvoice(@Header("token") String token, @QueryMap Map<String, String> map);

    //用户信息收集
    @POST(Interface.USERSAVEBEHAVIOR)
    Observable<PublicBean> userSaveBehavior(@QueryMap Map<String, String> map);
*/
 //用户信息收集
 @GET(Interface.SHOW)
 Observable<Object> getShowInfo();

}
