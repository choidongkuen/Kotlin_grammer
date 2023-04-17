fun main() {

    println("RED is ${getKoreanColorName(Color.RED)}")
    println("BLACK is ${getKoreanColorName(Color.BLACK)}")
}


enum class Color {
    RED, GREEN, BLUE, BLACK
}

fun getKoreanColorName(color: Color) = when (color) {

    Color.RED -> "빨강"
    Color.GREEN -> "녹색"
    Color.BLUE -> "파랑"
    Color.BLACK -> "검정"
}
