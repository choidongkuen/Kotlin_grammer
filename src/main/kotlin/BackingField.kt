class Account {
    var balance: Long = 0
        set(value) { // setter 커스텀마이징
            if (value < 0) throw IllegalArgumentException("잔액은 0원 이상만 가능합니다.")

            field = value
        }

    var accountName: String = "" // getter 커스텀마이징
        get() = "계좌이름 : $field"
}

//fun main() {
//    val account = Account()
//    account.balance = 100
//    account.accountName = "급여 계좌"
//
//    println("${account.accountName} \n 잔액 : ${account.balance}")
//
////    val account01 = Account01()
////    account01.accountName = "안녕"
//}

class Account01 {
    var balance: Int = 0
        private set

    var accountName: String = ""
        get() = "계좌이름 : $field"

    fun increaseBalance(value: Int) {

        if (this.balance + value > 1_000_000) throw java.lang.IllegalArgumentException("balance is over")
        this.balance += value
    }

    fun decreaseBalance(value: Int) {

        if (this.balance - value < 0) throw java.lang.IllegalArgumentException("balance is not enough")

        this.balance -= value
    }
}


fun main() {
    val account = Account01()
    account.increaseBalance(100)
    account.increaseBalance(100)
    account.accountName = "급여계좌"

    println("${account.accountName} 잔액 : ${account.balance}")
}
