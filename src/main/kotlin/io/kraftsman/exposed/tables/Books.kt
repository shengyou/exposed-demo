package io.kraftsman.exposed.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Table

//object Books : Table(name = "books") {
//    val id = integer("id").autoIncrement().entityId()
//    val title = varchar("title", 255)
//    val genre = varchar("genre", 255)
//    val isbn = varchar("isbn", 13)
//    val publisher = varchar("publisher", 255)
//
//    override val primaryKey = PrimaryKey(id)
//}

object Books : IntIdTable(name = "books") {
    val title = varchar("title", 255)
    val genre = varchar("genre", 255)
    val isbn = varchar("isbn", 13)
    val publisher = varchar("publisher", 255)
    val author = reference("author", Authors)
}

//object Books : UUIDTable(name = "books") {
//    val title = Books.varchar("title", 255)
//    val genre = Books.varchar("genre", 255)
//    val isbn = Books.varchar("isbn", 13)
//    val publisher = Books.varchar("publisher", 255)
//}
