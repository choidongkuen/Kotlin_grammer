sealed class Error {
    class FileError(val fileName: String) : Error()

    class DatabaseError(val dbmsType : DbmsType) : Error()
}

enum class DbmsType {
    MYSQL,H2,ORACLE,MARIA
}

fun getCharacter(error : Error) = when(error) {
    is Error.FileError -> "Error occurred at ${error.fileName}"
    is Error.DatabaseError -> "Error occurred ar ${error.dbmsType}"
    else -> 

}