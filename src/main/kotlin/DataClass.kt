data class Data(val name: String, val value: Int)

class Member(val name: String, val isMarried: Boolean)


object Family { // 클래스 선언과 동시에 객체 생성(단 한번 생성해서 단 한번 사용)
    val members = mutableListOf<Member>()
}

fun main() {
    println(Data("데이터", 1)) // toString() 생략 가능
    Family.members.add(Member("멤버1", false))
}