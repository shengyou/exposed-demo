package io.kraftsman.exposed.demo.dao

import io.kraftsman.exposed.entities.Author
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
        val author = Author.findById(1)
        author?.name = "Updated author name"
    }
}
