// Collections 연습
// Array
val arr = arrayOfNulls<Int>(10)


val initArr = arrayOf(1, null, 3)

val initDiffTypeArr = arrayOf(1, "2", 3L)

// 정수형 원소로 이루어진 배열
val initIntArr = intArrayOf(1, 2, 3)

val initConstructor = Array(10) { 1 }

val initConstructors = Array(10) { v -> v + 1 }

val initWithIncrement = (1..10).toList().toTypedArray()

val initWithIncrementByStep = (1..10).step(2).toList().toTypedArray()

// List

val listOf = listOf(1, 2, 3)
val lis = List(3) { v -> v + 1 }

val emptyMutableList = mutableListOf<Int>()
val mutableListOf = mutableListOf(1, 2, 3)
val mutableL = MutableList(2) { v -> v + 1 }


// map

val mapOf = mapOf("one" to 1, "two" to 2)
val mutableMapOf = mutableMapOf<String, Int>()

fun main() {

    for (i in initArr) {
        println(i)
    }

    println("------")

    for (i in initWithIncrement) {
        println(i)
    }


    println("------")


    for (i in initWithIncrementByStep) {
        println(i)
    }

    println(mutableL)
    println(listOf[2])
    println(lis.get(1)) // index 권고됨

    println(mutableListOf)

    mutableListOf.add(mutableList[mutableListOf.size - 1] + 1)

    println(mutableListOf)

    mutableListOf.remove(mutableListOf[mutableListOf.size - 1])

    println(mutableListOf)

    mutableListOf.add(mutableListOf.size - 1, 2)
    println(mutableListOf)


    val value = mapOf["one"] // 1

    mutableMapOf["one"] = 1

    val anotherValue = mutableMapOf["one"] // 1

    println(value == anotherValue)

}