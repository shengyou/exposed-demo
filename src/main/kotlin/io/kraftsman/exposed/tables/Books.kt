package io.kraftsman.exposed.tables

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.dao.id.UUIDTable
import org.jetbrains.exposed.sql.Table

//object Books : Table(name = "books") {
//    val id = integer("id").autoIncrement().entityId()
//    val title = varchar("title", 255)
//    val isbn = varchar("isbn", 13)
//
//    override val primaryKey = PrimaryKey(id)
//}

object Books : IntIdTable(/*name = "books"*/) {
    val title = varchar("title", 255)
    val isbn = varchar("isbn", 13)
}

//object Books : UUIDTable(name = "books") {
//    val title = varchar("title", 255)
//    val isbn = varchar("isbn", 13)
//}
