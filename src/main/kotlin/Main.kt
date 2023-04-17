fun main(args: Array<String>) {
    val developer = Developer("최동근",true,"Kotlin")

    val marketer = Marketer("김지후",false, Division.DIGITAL)

    println("developer's special skill is :  ${getSpecialSkill(developer)}")
    println("marketer's special skill is : ${getSpecialSkill(marketer)}")

}