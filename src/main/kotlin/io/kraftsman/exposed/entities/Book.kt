package io.kraftsman.exposed.entities

import io.kraftsman.exposed.tables.Books
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Book(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Book>(Books)

    var title by Books.title
    var genre by Books.genre
    var isbn by Books.isbn
    var publisher by Books.publisher
}
