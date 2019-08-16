package jialei.com

fun main(args: Array<String>) {

    var name  = "abc"
    var age = 8
    println("hello kotlin" + name + age)

    var s:String = "haha"
    var a:Int
    a = 21

    println("hello kotlin" + s + a)

    var aByte = Byte.MAX_VALUE

    println("max byte: " + aByte)

    var num3 = Math.sqrt(5.0)  - Math.sqrt(4.0)
    var num4 = Math.sqrt(4.0) - Math.sqrt(3.0)
    println(num3 > num4)

    var b:Boolean

}

fun run(num: Int):Int {
    return 123
}