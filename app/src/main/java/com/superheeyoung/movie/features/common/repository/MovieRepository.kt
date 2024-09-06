package com.superheeyoung.movie.features.common.repository

import com.superheeyoung.movie.features.common.network.MovieNetworkApi
import com.superheeyoung.movie.features.common.network.MovieResultResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi : MovieNetworkApi
): MovieDataSource {
    override suspend fun getMovieList() : List<MovieResultResponse> {
        return movieNetworkApi.getMovies().results
    }
}