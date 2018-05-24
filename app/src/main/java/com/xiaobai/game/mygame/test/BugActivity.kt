package com.xiaobai.game.mygame.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

/**
 * Created on 2018/5/24.
 *
 * @author wr
 * @version 1.0.0
 */

class BugActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this@BugActivity, "2333 welcome ~~", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}
