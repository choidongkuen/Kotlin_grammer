open class Professor(
    val lectureName: String,
    val professorName: String
)

class Student : Professor {
    private val studentName: String

    constructor(studentName: String, lectureName: String, professorName: String) : super(lectureName, professorName) {
        this.studentName = studentName
    }

    fun introduce() {
        println("저는 ${studentName} 입니다. \n 저의 교수님은 ${professorName} 이시며, 강의명은 ${lectureName}입니다.")
    }


}
