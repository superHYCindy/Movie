package com.superheeyoung.movie.features.common.repository

interface MovieDataSource {
    suspend fun getMovieList()
}