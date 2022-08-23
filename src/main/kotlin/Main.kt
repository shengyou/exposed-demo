import io.kraftsman.exposed.tables.Authors
import io.kraftsman.exposed.tables.Books
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
        SchemaUtils.create(
            Books,
            Authors,
        )
    }
}