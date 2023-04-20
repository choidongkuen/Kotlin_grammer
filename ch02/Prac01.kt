class Test01 constructor(val name: String, val value: Int) { // 클래스 생성자를 선언부에 선언 -> 기본 생성자
}

class Test02(val name: String, val value: Int) // constructor 생략 가능

class Test03(name: String) {

    // 기본 생성자의 인자 없음
    constructor(name: String, value: Int) : this(name) {
        println("${name} 그리고 ${value}")
    }
}

class Test04(val name: String = "No Name", val age: Int = 0) // 생성자의 default 값 설정

class Test05(var name: String?, var age: Int = 0) { // 기본 생성자는 함수 바디를 가질 수 없음 -> Init 사용
    init {
        if (name.isNullOrBlank()) name = "No Name"
    }
}


fun main() {

    val test01 = Test01("스트링", 0)
    println("${test01.value}")

    val test04 = Test04()
    println("${test04.name} 과 ${test04.age}")

    val test05 = Test05(null, 2)
    println("${test05.name} 과 ${test05.age}")
}