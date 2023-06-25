var mutableList = mutableListOf(1, 2, 3)
var mutableMap = mutableMapOf(1 to "ONE")


fun printMap() {

    val map = mapOf(1 to "One", 2 to "Two")
    var newMap = map - 1 // 1 -> key
    newMap += 3 to "Three"
    print(newMap)
    println()

    val immutableMap = mapOf(1 to "one", 2 to "two")
    print(immutableMap.get(1))
}

fun printList() {
    val list = listOf(1, 2, 3, 4, 5)

    for (i in 0..list.size - 1) {
        print(list.get(i))
    }

    println()
    var newList = list - 2
    for (i in 0..newList.size - 1) {
        print(newList.get(i))
    }
}

fun filterNullableValueInList() {
    val list = listOf(1, 2, 3, 4, 5, null, null, 10)

    println()
    var nameList = list.filterNotNull()
    print(nameList)
}

fun main() {
    printMap()
    printList()
    filterNullableValueInList()
}