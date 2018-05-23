package com.xiaobai.game.mygame.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

import com.xiaobai.game.mygame.R
import com.xiaobai.game.mygame.http.BaseEntity
import com.xiaobai.game.mygame.http.NetWork
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_test.*
import java.util.*

/**
 * Created on 2018/5/23.
 * 测试页面
 * @version 1.0.0
 * @author wr
 */

class TestActivity : AppCompatActivity() {

    val TAG = "TestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        bt_show.setOnClickListener({ serverTest(); })
    }

    /**
     * 获取测试详情
     */
    private fun serverTest() {
        NetWork.getInstance(this).getAPI().getShow( object : Observer<BaseEntity<Any>> {
            override fun onSubscribe(d: Disposable) {
                Log.d(TAG,"onSubscribe")
            }

            override fun onNext(value: BaseEntity<Any>) {
                Log.d(TAG,"onNext:   "+value.toString())
                tv_show.text = value.toString()
            }

            override fun onError(e: Throwable) {
                Log.d(TAG,"onError")
            }

            override fun onComplete() {
                Log.d(TAG,"onComplete")
            }
        })

    }
}
