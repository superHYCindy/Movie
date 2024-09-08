package com.superheeyoung.movie.features.feed.domain

import com.superheeyoung.movie.features.common.repository.MovieDataSource
import com.superheeyoung.movie.features.feed.data.mapper.MovieMapper
import javax.inject.Inject

class GetMovieListUseCase @Inject constructor(
    private val movieDataSource: MovieDataSource,
    private val movieMapper: MovieMapper
) {
    suspend operator fun invoke() =
        movieMapper.transform(
            movieDataSource.getMovieList()
        )
}