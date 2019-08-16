package jialei.com

import java.util.*

fun main() {
    var age = 18
    if(age < 16){
        println("small")
    }else{
        println("big")
    }

    var numbs = 1 .. 100
    println(numbs.indexOf(50))

    for (num in numbs){
        println("${num}")
    }

    var numbbs = 1 until 100

    var lists = listOf<String>("a", "b", "c")
    for ((i, e) in lists.withIndex()){
        println("${i} and ${e}")
    }

    var map = TreeMap<String, String>()
    map["hao"] = "good"

    println(map["hao"])


    var s = "a1"
    try {
        println(s.toInt())
    }catch (e: Exception){

    }


}

fun getWhen(scroe: Int){
    when(scroe){
        10 -> println("aa")
        9 -> println("bb")
        else -> println("ss")
    }
}