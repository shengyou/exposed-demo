package io.kraftsman.exposed.dsl

import io.kraftsman.exposed.tables.Books
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
        Books.update({ Books.id eq 1 }) {
            it[Books.title] = "Updated book title"
        }
    }
}
