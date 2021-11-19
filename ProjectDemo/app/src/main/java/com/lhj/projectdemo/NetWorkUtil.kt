package com.lhj.projectdemo

import android.content.Context
import android.util.Log
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


/**
 * 项目：国民健康平台
 *  @Creator:liuhuajian
 *  @创建日期： 2021/1/26 14:46
 *  @版本0.2
 *  @类说明：
 */
class NetWorkUtil {
    companion object{
        val instance =NetWorkUtil()
    }

    private val platforms = arrayOf(
        "https://pv.sohu.com/cityjson",
        "https://pv.sohu.com/cityjson?ie=utf-8",
        "https://ip.chinaz.com/getip.aspx"
    )

    fun getOutNetIP(context: Context?, index: Int): String? {
        var index = index
        if (index < platforms.size) {
            var buff: BufferedReader? = null
            var urlConnection: HttpURLConnection? = null
            try {
                val url = URL(platforms[index])
                urlConnection = url.openConnection() as HttpURLConnection
                urlConnection.requestMethod = "GET"
                urlConnection.readTimeout = 5000 //读取超时
                urlConnection.connectTimeout = 5000 //连接超时
                urlConnection.doInput = true
                urlConnection.useCaches = false
                val responseCode: Int = urlConnection.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) { //找到服务器的情况下,可能还会找到别的网站返回html格式的数据
                    val `is`: InputStream = urlConnection.inputStream
                    buff = BufferedReader(InputStreamReader(`is`, "UTF-8")) //注意编码，会出现乱码
                    val builder = StringBuilder()
                    var line: String? = null
                    while (buff.readLine().also { line = it } != null) {
                        builder.append(line)
                    }
                    buff.close() //内部会关闭 InputStream
                    urlConnection.disconnect()
                    Log.e("xiaoman", builder.toString())
                    if (index == 0 || index == 1) {
                        //截取字符串
                        val satrtIndex = builder.indexOf("{") //包含[
                        val endIndex = builder.indexOf("}") //包含]
                        val json =
                            builder.substring(satrtIndex, endIndex + 1) //包含[satrtIndex,endIndex)
                        val jo = JSONObject(json)
                        return jo.getString("cip")
                    } else if (index == 2) {
                        val jo = JSONObject(builder.toString())
                        return jo.getString("ip")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else {
            return "未找到外网地址"
        }
        return getOutNetIP(context, ++index)
    }
}