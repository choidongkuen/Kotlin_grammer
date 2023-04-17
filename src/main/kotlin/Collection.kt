val set = setOf(1, 2, 3)
val list = listOf("a", "b", "1L")

val map = mapOf(
    1 to "One",
    2 to "two"
)

fun main() {
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(getMyName("Jobs", "Steve"))
    println(getMyName(firstName = "동근", lastName = "최"))

    println(getDefaultMyName())
}

fun getMyName(
    firstName: String,
    lastName: String
): String = "$firstName $lastName"

fun getDefaultMyName( // Default 메소드
    firstName: String = "foo",
    lastName: String = "boo"
): String = "$firstName $lastName"

