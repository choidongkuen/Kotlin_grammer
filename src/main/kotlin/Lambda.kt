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
}

