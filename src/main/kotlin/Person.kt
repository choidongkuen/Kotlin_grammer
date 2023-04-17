sealed class Person(
    val name: String,
    val isMarried: Boolean
)

class Developer(
    name: String,
    isMarried: Boolean,
    val language: String

) : Person(
    name,
    isMarried
)

class Marketer(
    name: String,
    isMarried: Boolean,
    val division: Division
) : Person(
    name,
    isMarried
)

enum class Division {
    CONTENTS, DIGITAL, BRAND
}

fun getSpecialSkill(person: Person) =
    when (person) {
        is Developer -> person.language
        is Marketer -> person.division
    }
