package com.superheeyoung.movie.features.common.network

import com.google.gson.annotations.SerializedName

data class MovieResponse<T>(
    @SerializedName("results")
    val results : List<T>
)

data class MovieResultResponse(
    @SerializedName("id")
    val id : Int,
    @SerializedName("poster_path")
    val posterPath : String,
    @SerializedName("title")
    val title : String,
    @SerializedName("overview")
    val overview : String,
    @SerializedName("vote_average")
    val voteAverage : Float
)