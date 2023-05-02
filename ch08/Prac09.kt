// for & while
val item = Array(5) { v -> v + 1 }
var index = 0
fun main() {
    while (index < item.size) {
        println(item[index])
        index++
    }

    // 1 ~ 99
    for (i in 1 until 100) {
        println("$i")
    }

    println("--------")

    // 1 ~ 100
    for (i in 1..100) {
        println("$i")
    }

    for (i in 10 downTo 1) {
        println("$i")
    }

    for (i in 2 until 10 step 2) {
        println("$i ")
    }
}