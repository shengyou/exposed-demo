package io.kraftsman.exposed.demo.dsl

import io.kraftsman.exposed.tables.Books
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
        Books.selectAll().forEach {
            println("\"${it[Books.title]}\" published by ${it[Books.publisher]}")
        }

        Books.select { Books.id lessEq 5 }
            .orderBy(Books.id to SortOrder.DESC)
            .forEach {
                println("(${it[Books.id]}) ${it[Books.title]}")
            }
    }
}
