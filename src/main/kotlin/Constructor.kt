//class User constructor(_userName : String) {
//    val userName : String
//
//    init {
//        this.userName = _userName
//    }
//}
//


//class User constructor(_userName : String) {
//    val userName : String = _userName
//}

class User(val userName: String = "defaultName")


val userName = User("최동근").userName

val userName01 = User().userName

fun main() {
    println(userName01)
}