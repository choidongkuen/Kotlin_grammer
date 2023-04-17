

infix fun String.add(postfix: String) =
    this + postfix


fun main() {
    println("This is ".add("good"))
    println("This is " add("good")) // infix 함수 적용
}
