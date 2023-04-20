val elements: List<Int> = listOf(1, 2, 3, 4)

class Prac04 {

    fun for01() {
        for (i in 2..9) {
            println(i)
        }
    }

    fun for02() {
        for (i in 2..9 step 2) {
            println(i)
        }
    }

    fun for03() {
        for (i in 10 downTo 1) {
            println(i)
        }
    }


    fun for04() {
        for (i in 0..elements.size - 1) {
            println(elements[i])
        }
    }

}

fun main() {
    val test = Prac04()
    test.for01()
    print("------\n")
    test.for02()
    print("------\n")
    test.for03()
    print("------\n")
    test.for04()
}


