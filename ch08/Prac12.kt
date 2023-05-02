// 생성자 오버로딩(여러개의 생성자)
// 만약 멤버 변수(프로퍼티) 를 private 선언하는 경우 getter/setter 존재 x

class OverLoadingConstructor(name: String) {
    var name: String

    // lateinit : 멤버 변수의 값 초기화를 지연하는 키워드
    // 1. var 필수
    // 2. non-null 프로퍼티만 사용 가능
    // 3. primitive 사용 불가
    // 4. 생성자에는 사용 불가
    // 5. 로컬 변수로 사용 불가능
    lateinit var address: String


    var age: Int = 0


    init {
        this.name = name
    }

    // this(name) : name 만을 인자로 받는 생성자 호출
    constructor(name: String, address: String, age: Int) : this(name) {
        this.name = name
        this.address = address
        this.age = age
    }
}


fun main() {

    val overLoadingConstructor01 = OverLoadingConstructor("최동근")
    val overLoadingConstructor02 = OverLoadingConstructor("최동근", "시흥시", 27)

    println(overLoadingConstructor02)
}