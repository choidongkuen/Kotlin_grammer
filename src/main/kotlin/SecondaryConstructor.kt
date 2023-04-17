open class Parent(
    val familyName: String
)
class Child : Parent {

    private val subName : String

    constructor(subName: String) : this(subName,"")
    
    constructor(subName: String, familyName: String) : super(familyName) {
        this.subName = subName
    }
}