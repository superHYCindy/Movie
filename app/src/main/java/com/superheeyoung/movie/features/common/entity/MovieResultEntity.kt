package com.superheeyoung.movie.features.common.entity

import com.google.gson.annotations.SerializedName

data class MovieResultEntity(
    val id : Int,
    val posterPath : String,
    val title : String,
    val overview : String,
    val voteAverage : Float
)
