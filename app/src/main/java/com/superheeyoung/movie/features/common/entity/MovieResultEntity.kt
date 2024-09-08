package com.superheeyoung.movie.features.common.entity

import com.superheeyoung.movie.features.feed.data.GenreType

data class MovieResultEntity(
    val genreType: GenreType,
    val movieEntities : List<MovieFeedEntity>
)

data class MovieFeedEntity(
    val id : Int,
    val posterPath : String,
    val title : String,
    val overview : String,
    val voteAverage : Float
)
