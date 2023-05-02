fun basicFunc(name: String): Int {

    // 인자의 문자열을 정수형으로 변환하는 함수
    return name.toInt()
}

fun simpleFunc(name: String = "Default", age: Int): String {
    return name
}

// vararg : 가변인자
fun <T> newList(vararg ts: T): List<T> {
    val result = ArrayList<T>()

    for (t in ts) {
        result.add(t)
    }

    return result
}

// 가변인자 + 일반인자
fun printString(title: String, vararg strings: String): Unit {
    println("this is a not vararg : $title")

    println("------------")

    println("this is a vararg")
    for (string in strings) {
        println(string)
    }
}

// 배열을 인자로 받는 경우 호출하는 곳에서 * 사용하여 가변인자 처럼 전달
fun printArray(vararg ts: String) {
    for (string in ts) {
        println(string)
    }
}

fun main() {
    println(basicFunc("2"))
    println(simpleFunc(age = 2)) // name 이 default 값으로 넘어가는 경우 인자 명시를 해줘야 함
    println(simpleFunc("최동근", 100))
    // 인자 명시를 할 경우 인자 순서 변경 가능 -> 즉 함수의 파라미터를 선언된 순서가 아닌 호출시에 지정 가능
    var result = simpleFunc(age = 100, name = "최동자")

    printString("제목1", "vararg1", "vararg2")

    val arr = arrayOf("one", "two")
    printArray(*arr)

}

