package com.superheeyoung.movie.features.feed.data

enum class GenreType(val id : Int) {
    ACTION(28),
    Adventure(12),
    Animation(16),
    UNKNOWN(-1)
}

fun findGenreType(id : Int) : GenreType {
    return GenreType.entries.find { id == it.id } ?: GenreType.UNKNOWN
}