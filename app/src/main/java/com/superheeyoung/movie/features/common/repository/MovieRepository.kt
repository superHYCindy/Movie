package com.superheeyoung.movie.features.common.repository

import com.superheeyoung.movie.features.common.network.MovieNetworkApi
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi : MovieNetworkApi
): MovieDataSource {
    override suspend fun getMovieList() {
        TODO("Not yet implemented")
    }
}