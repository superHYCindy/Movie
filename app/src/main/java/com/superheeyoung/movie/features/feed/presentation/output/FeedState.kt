package com.superheeyoung.movie.features.feed.presentation.output

import com.superheeyoung.movie.features.common.entity.MovieResultEntity

sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val movieList: List<MovieResultEntity>
    ) : FeedState()

    class Failed(
        val reason: String
    ) : FeedState()
}