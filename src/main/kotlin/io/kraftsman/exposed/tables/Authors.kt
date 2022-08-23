package io.kraftsman.exposed.tables

import org.jetbrains.exposed.dao.id.IntIdTable

object Authors: IntIdTable(name = "authors") {
    val name = varchar("name", 255)
}
