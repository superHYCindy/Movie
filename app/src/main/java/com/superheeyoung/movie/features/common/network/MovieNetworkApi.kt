package com.superheeyoung.movie.features.common.network

import com.superheeyoung.movie.library.network.model.ApiResult
import retrofit2.http.GET

interface MovieNetworkApi {
    @GET("movie/now_playing")
    suspend fun getMovies() : MovieResponse<MovieResultResponse>
}