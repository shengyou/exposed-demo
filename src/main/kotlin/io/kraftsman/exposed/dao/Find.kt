package io.kraftsman.exposed.dao

import io.kraftsman.exposed.entities.Author
import io.kraftsman.exposed.tables.Authors
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
        Author.all().forEach {
            println(it.name)
        }

        Author.find { Authors.id lessEq 5 }
            .orderBy(Authors.id to SortOrder.DESC)
            .forEach {
                println("(${it.id}) ${it.name}")
            }
    }
}
