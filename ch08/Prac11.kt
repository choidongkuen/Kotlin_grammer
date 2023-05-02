// 1. 확장 함수

val arrayOf = arrayOf(1, 2, 3)
fun <T> Array<T>.length(): Int {
//    println("해당 배열의 길이 - 1을 출력합니다.")
    return 1
}


// 클래스의 () 안에 val/var 을 붙이지 않으면 생성자의 매개변수와 프로퍼티(멤버 변수) 따로 선언한 꼴
class BasicClass(name: String, address: String) {
    var name: String
    var address: String

    // 생성자의 매개변수와 프로퍼티가 따로 선언된 경우, init 블록 필수!
    init {
        this.name = name
        this.address = address
    }

}

class GetterSetterClass(name: String, address: String, age: Int) {
    var name: String
    var address: String = ""
        get() = "$field 특별시"
        set(address) {
            field = "$address 특별시"
        }

    // field = address ?

    var age: Int

    init {
        this.name = name
        this.address = address
        this.age = age
    }
}


fun <T> Array<T>.addMethod(index1: Int, index2: Int): Int {
    println("두 인자를 더합니다.")
    return index1 + index2
}

fun main() {
    val addMethod = arrayOf.addMethod(1, 3)
    println(addMethod)

    val length = arrayOf.length()
    println(length)

    val getterSetterClass = GetterSetterClass("최동근", "서울", 27)
    println(getterSetterClass.address)
}