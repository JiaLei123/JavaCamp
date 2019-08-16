package jialei.com

fun main() {
    println(getStr("Japan"))
    var home = "China"
    var tem = "back to ${home}"
    println(tem)
    getStr(null);


    var i = {x:Int, y:Int -> x+ y}
    println(i(2, 5))

    var j :(Int, Int)->Int = {x,y -> x + y}
    println(j(2, 5))

    println(adds(b=100))

    var v = 100
    println(v.toString())

    var s = null
    var nn = s?.toInt();
    println(nn)


    var num1Str = readLine()
    var num1 = num1Str?.toInt()

    println(num1)
}

fun getStr(placeName: String?):String{
    var templae = "go to ${placeName}";
    return templae
}

fun adds(a:Int = 100, b:Int):Int {
    return a + b
}

fun add(src: Int, target: Int): Int {
    return src + target
}

fun plus(a:Int, b:Int):Int = a+b