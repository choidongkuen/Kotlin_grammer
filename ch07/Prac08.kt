open class Fruit
class Apple : Fruit()
class Banana : Fruit()

fun receiveArr(fruits: Array<Fruit>) {
    println("Number : ${fruits.size}")
}

fun receiveList(fruits: List<Fruit>) {
    println("Number : ${fruits.size}")
}


fun copyFromTo(from: Array<out Fruit>, to: Array<Fruit>) {

    println("something")
}

fun main() {
    val appleArray = arrayOf(Apple())
//    receiveArr(appleArray) -> 오류 발생

    val appleList: List<Apple> = listOf(Apple())
    receiveList(appleList)
    val fruitArray: Array<Fruit> = arrayOf(Fruit())

    copyFromTo(appleArray, fruitArray) // 오류 발생 x
}