import java.util.*

fun main() {

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'Z') {
        val binary = Integer.toBinaryString(c.code)
        binaryReps[c] = binary
    }

    for((key,value) in binaryReps) {
        println("문자 : ${key}, 아스키코드:${value}")
    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
    fun isNotLetter(c: Char) = c in '0'..'9'
}
