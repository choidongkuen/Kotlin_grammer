class Object(
    val name: String,
    val age: Int
)

const val int: Int = 29
const val long: Long = int.toLong()

fun main() {
    val nullableObject: Object? =
        if (System.currentTimeMillis() % 2 == 0L) Object("이름", 2)
        else null // 홀수면 null


    if (nullableObject != null) { // null 값 체크해야 함
        println("짝수 시간에만 존재하는 객체의 나이는 ${nullableObject.age}")
    }

    // ?. 호출을 수행 : 값이 있는 경우는 호출 결과, 값이 없는 경우 null
    println("짝수 시간에만 존재하는 객체의 나이는 ${nullableObject?.age}") // 호출로 호출하거나 혹은 null 을 주거나

    // !!. 호출을 수행 : 값이 없는 경우 NPE 발생
    println("짝수 시간에만 존재하는 객체의 나이는 ${nullableObject?.age}") // 호출로 강제 호출을 하거나 혹은 NPE 발생하거나

}


// Elvis operator
// null 값 존재시 기본값으로 대체!

