package io.kraftsman.exposed.relationships

import io.kraftsman.exposed.entities.Author
import io.kraftsman.exposed.entities.Book
import io.kraftsman.exposed.tables.Authors
import org.jetbrains.exposed.dao.with
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction

fun main() {
    Database.connect(
        url = "jdbc:mysql://localhost:8889/sample",
        driver = "com.mysql.cj.jdbc.Driver",
        user = "root",
        password = "root"
    )

    transaction {
//        Book.all().map {
//            println("(${it.title} by ${it.author.name}")
//        }

        Book.all().with(Book::author).map {
            println("(${it.title} by ${it.author.name}")
        }

//        val author = Author.findById(1)
//        author?.books?.forEach {
//            println("${author.name} wrote \"${it.title}\"")
//        }
    }
}