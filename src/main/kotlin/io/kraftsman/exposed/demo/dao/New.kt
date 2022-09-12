package io.kraftsman.exposed.demo.dao

import com.github.javafaker.Faker
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

    val faker = Faker()

    transaction {
        repeat(20) {
            Author.new {
                name = faker.book().author()
            }
        }
    }
}
