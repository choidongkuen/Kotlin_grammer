interface Clickable {
    fun click()
}

class Button : Clickable {
    override fun click() {
        println("버튼을 클릭했습니다.")
    }
}


fun main() {
    val button = Button().click()
}

// open, final, abstract = public, final, abstract
// 코틀린은 기본적으로 final -> 상속하기 위해서는 open