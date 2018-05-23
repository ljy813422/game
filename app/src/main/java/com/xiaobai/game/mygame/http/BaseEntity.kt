
package com.xiaobai.game.mygame.http
/**
 * Created on 2018/5/15.
 *
 * @author wr
 * @version 1.0.0
 */

class BaseEntity<T> {
    var code: Int = 0
    var msg: String? = null
    var error: String? = null
    var data: T? = null
    override fun toString(): String {
        return "BaseEntity(code=$code, msg=$msg, error=$error, data=$data)"
    }
}
