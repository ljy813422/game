package com.xiaobai.game.mygame.http
/**
 *  http 配置对象
 * Created on 2018/5/14.
 * @author wr
 * @version 1.0.0
 */
object HttpConfig {
    val HTTP_CONNECT_TIME = 10 //设置连接超时时间
    val HTTP_READ_TIME = 30 //设置读取超时时间
    val HTTP_WRITE_TIME = 30 //设置写入超时时间
    val BASE_URL = "http://172.16.205.1:8081/myGame/"
}