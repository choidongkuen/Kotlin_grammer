val x = 1001


fun test() {
    when {
        x < 100 -> {
            println("x는 100 미만입니다.")
        }

        x < 1000 -> {
            println("x는 1000 미만입니다.")
        }

        x >= 1000 -> {
            println("x는 1000 이상입니다.")
        }
    }
}

fun main() {
    test()
}