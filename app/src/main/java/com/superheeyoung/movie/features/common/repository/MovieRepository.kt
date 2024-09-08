package com.superheeyoung.movie.features.common.repository

import com.superheeyoung.movie.features.common.network.ApiResponse
import com.superheeyoung.movie.features.common.network.MovieNetworkApi
import com.superheeyoung.movie.features.common.network.MovieResultResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi: MovieNetworkApi
) : MovieDataSource {
    override suspend fun getMovieList(): ApiResponse<List<MovieResultResponse>> {
        return try {
            val response = movieNetworkApi.getMovies()
            ApiResponse.Success(response.results)
        } catch (e: Exception) {
            ApiResponse.Fail(e)
        }
    }
}