package com.superheeyoung.movie.features.feed.presentation.output

import com.superheeyoung.movie.features.common.network.MovieResultResponse

/*
sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val movieList: List<MovieFeedItemEntity>
    ) : FeedState()

    class Failed(
        val reason = String
    ) : FeedState()
}*/
sealed class FeedState {
    object Loading : FeedState()
    class Main(
        val movieList : List<MovieResultResponse>
    ) : FeedState()
    class Failed(
        val reason : String
    ) : FeedState()
}