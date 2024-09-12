package com.superheeyoung.movie.features.common.entity

import android.os.Parcelable
import com.superheeyoung.movie.features.feed.data.GenreType


data class MovieResultEntity (
    val movieEntities: List<MovieFeedEntity>,
    val genreType: GenreType
)

data class MovieFeedEntity(
    val id : Int,
    val posterPath : String,
    val title : String,
    val overview : String,
    val voteAverage : Float
)
