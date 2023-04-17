sealed class Error { // 확장을 제한하여 편의성을 향상시키는 클래스 타입
    class FileError(val fileName: String) : Error()

    class DatabaseError(val dbmsType : DbmsType) : Error()

    class OsError(val osType : OsType) : Error()
}

enum class OsType {
    MAC,WINDOW,LINUX

}

enum class DbmsType {
    MYSQL,H2,ORACLE,MARIA
}

fun getCharacter(error : Error) = when(error) {
    is Error.FileError -> "Error occurred at ${error.fileName}"
    is Error.DatabaseError -> "Error occurred at ${error.dbmsType}"
    is Error.OsError -> "Error occurred at ${error.osType}" // sealed Class 사용시 when 에서 불필요한 else 생략 가능
}