data class Dog(
    val name: String,
    val gender: Gender,
    val age: Int
)

enum class Gender {
    MALE, FEMALE
}

val dogs = listOf(
    Dog("바둑이", Gender.MALE, 2),
    Dog("초코", Gender.FEMALE, 5),
    Dog("나라", Gender.FEMALE, 1)
)

fun main() {
    println(dogs.maxByOrNull { it -> it.age })
    println(dogs.minByOrNull { dog: Dog -> dog.age })

    println(dogs.filter { it -> it.gender == Gender.FEMALE }
        .map { "${it.name} 강이지는 ${it.age} 살 입니다." })

    // group by
    println(dogs.groupBy { it.gender }) // MALE = [], FEMALE = []

    // flatMap
    val strings = listOf("abc", "def")
    println(strings.map { it.toList() }) // 2중 리스트
    println(strings.map { it.toList() }.flatten())

    // sequence
    println(dogs.asSequence()
        .map {
            println(it)
            it.name
        }.find { it.startsWith("d") })

}
