class Test06 {
    var name: String = ""
    var age: Int = 0
}

class Test07 {

    // getter,setter 를 오버라이딩 하는 경우 field 변수 사용
    // getter,setter 메소드는 변수의 접근 제한을 따름
    var name: String = ""
        get() = "Name : $field"
        private set // block setter

    var age: Int = 0
        set(age) {
            field + 1
        }

}


fun main() {
    val test06 = Test06()
    println(test06.age) // getter
    println(test06.age) // getter

    test06.age = 20 // setter
    println(test06.age)
}