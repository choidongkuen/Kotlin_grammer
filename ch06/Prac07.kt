// is as
fun isAsTest(a: Any) {

    if (a is String) {
        println("a 는 문자열 입니다.")
    } else if (a is Int) {
        println("a 는 정수형 입니다.")
    }

}

// == ans === test

fun compareTest(a: String, b: String) {

    if (a == b) {
        println("두 문자열은 동일한 값을 가집니다.")
    }

    if (a === b) {
        println("두 문자열은 동일한 주소를 가집니다.")
    } else {
        println("두 문자열은 다른 값 다른 주소를 가집니다.")
    }
}

fun main() {

    val a: String = "abc"
    isAsTest(a)

    val b: String = "abc" // 자바 처럼 동일한 문자열이면 하나의 주소값을 공유하는 구나 -> 메모리 측면에서 good
    compareTest(a, b)
}