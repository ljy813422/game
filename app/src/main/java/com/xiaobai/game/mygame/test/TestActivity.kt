package com.xiaobai.game.mygame.test

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.KeyEvent
import android.widget.Toast

import com.xiaobai.game.mygame.R
import com.xiaobai.game.mygame.http.BaseEntity
import com.xiaobai.game.mygame.http.NetWork
import com.xiaobai.game.mygame.util.DialogUtil
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_test.*

/**
 * Created on 2018/5/23.
 * 测试页面
 * @version 1.0.0
 * @author wr
 */

class TestActivity : AppCompatActivity() {
    private var subscribe: Disposable?=null
    val TAG = "TestActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
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
                tv_show.text = e.toString()
            }

            @SuppressLint("SetTextI18n")
            override fun onComplete() {
                Log.d(TAG,"onComplete")
                tv_show.text = "onComplete"
            }
        })
    }

    /**
     * 初始化ob
     */
    override fun onStart() {
        super.onStart()
        initObservable()
    }


    /**
     * 初始
     */
    private fun initObservable() {
        var btShowObservable  = createBtShowObservable()
        var btBugObservable  =createBtBugObservable()
        val merge = Observable.merge(btShowObservable, btBugObservable)
        subscribe = merge.observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { t: Any? ->
                    if ("bug".equals(t)) {
                        Toast.makeText(this@TestActivity, "bug", Toast.LENGTH_LONG).show()
                    } else {
                        serverTest()
                    }
                }
    }

    private fun createBtShowObservable(): Observable<Any> {
        return Observable.create( { e: ObservableEmitter<Any>? ->
            bt_show.setOnClickListener({
                e?.onNext("click")
            })
            e?.setCancellable {
                bt_show.setOnClickListener(null)
            }
        })
    }


    private fun createBtBugObservable(): Observable<Any> {
        return Observable.create( { e: ObservableEmitter<Any>? ->
            bt_bug.setOnClickListener({
                e?.onNext("bug")
            })
            e?.setCancellable {
                bt_bug.setOnClickListener(null)
            }
        })
    }
    /**
     * ob解绑
     */
    override fun onStop() {
        super.onStop()
        if (subscribe!=null &&!subscribe!!.isDisposed){
            subscribe!!.dispose()
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
           DialogUtil.exit(this@TestActivity)
        }
        return super.onKeyDown(keyCode, event)

    }
}
