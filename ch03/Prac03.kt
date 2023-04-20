class Test09(name: String, value: Int) {

    val paraName: String
    val paraValue: Int

    init {
        if (name.isEmpty()) {
            throw IllegalArgumentException("잘못된 인자 요청입니다.")
        }
        paraName = name
        paraValue = value
    }

}

// 함수의 덧셈
fun add01(x: Int, y: Int) = x + y

// 함수의 덧셈 기본 값 설정
fun add02(x: Int, y: Int = 100) = x + y


fun main() {

    val test09 = Test09("이름", 1)
    println("${test09.paraName} & ${test09.paraValue}")

    println(add01(1, 2))
    println(add02(2))
}