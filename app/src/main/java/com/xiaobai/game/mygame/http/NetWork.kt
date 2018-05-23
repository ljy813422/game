package com.xiaobai.game.mygame.http

import android.content.Context

/**
 *  网络请求入口类
 * Created on 2018/5/15.
 * @author wr
 * @version 1.0.0
 */
 open class NetWork {

    private var api: API = API()

    /**
     * 获取 API实例
     */
    fun getAPI(): API {
        return api
    }

    companion object{
        private var instanced: Any?=null
        /**
         * 获取 NetWork实例
         */
        fun getInstance(mContext: Context) :NetWork{
            if (null == instanced) instanced = NetWork()
            return instanced as NetWork
        }
    }

}

