package jialei.com.proxy

/*
class Father: IWashBowl {
    override fun wash() {
        println("father wash")
    }
}
*/


//class Father: IWashBowl by BigHeadSon() {
//    override fun wash() {
//        BigHeadSon().wash()
//    }
//}


class Father: IWashBowl by BigHeadSon {
    override fun wash() {
        BigHeadSon.wash()
    }
}

fun main() {
    var man = Father();
    man.wash()
}