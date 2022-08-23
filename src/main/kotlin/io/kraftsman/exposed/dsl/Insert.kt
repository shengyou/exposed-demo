package io.kraftsman.exposed.dsl

import com.github.javafaker.Faker
import io.kraftsman.exposed.tables.Books
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    val faker = Faker()

    transaction {
        (1..20).forEach { _ ->
            Books.insert {
                it[title] = faker.book().title()
                it[genre] = faker.book().genre()
                it[isbn] = faker.code().isbn13()
                it[publisher] = faker.book().publisher()
            }
        }
    }
}
