import org.jetbrains.exposed.sql.Database

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )
}