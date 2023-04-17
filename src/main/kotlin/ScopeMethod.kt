class Scope(
    var name: String,
    var value: Int
)

fun main() {

    val scopes = listOf(
        Scope("One", 1),
        Scope("Two", 2),
        Scope("Three", 3)
    )

    with(scopes[1]) { // with
        println(name)
        println(value)
    }

    val scopeThree = scopes[2].apply {
        // apply : 객체의 값을 한번에 여러개 설정하는 경우
        // 객체 참조 : this
        // 응답 : 객체 자신
        name = "newName"
        value = 72
    }
    // also
    // 추가적인 효과를 적용하기 위해 주로 사용
    // 객체 참조 : it
    // 응답 : 객체 자신
    scopes.also {
        if (it.size < 2) throw IllegalStateException("scopes 크기가 너무 작습니다.")
        println("scopes 를 모두 완성하였습니다.")
    }

    // run
    // 객체의 값 설정, 추가적인 연산 진행에 사용
    scopes.run {
        println(this.map { "${it.name}'s value : ${it.value}" })
    }

}