package jialei.com.stc

import com.alibaba.fastjson.JSON
import com.alibaba.fastjson.TypeReference

fun main() {


    var jsonStr = "{\"scanStatus\":\"Completed\",\"result\":{\"whiteScanStatus\":{\"display\":\"已修复\",\"isBlock\":\"false\",\"status\":\"Fixed\",\"securityCountersigner\":\"\",\"qualityDirector\":\"\"},\"blackScanStatus\":{\"display\":\"无需扫描\",\"isBlock\":\"false\",\"status\":\"UnNeed\",\"securityCountersigner\":\"\",\"qualityDirector\":\"\"}},\"success\":\"true\"}"
    try{
        var stc = JSON.parseObject(jsonStr, object : TypeReference<StcQueryResponse>() {})
        println("解析完成")
    }catch (ex:Exception){
        println(ex)
    }


}
