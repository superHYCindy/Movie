package com.superheeyoung.movie.features.feed.presentation.shared

import com.superheeyoung.movie.features.common.entity.MovieFeedEntity

sealed interface FeedSharedEvent {

    data class SelectFeedItem(
        val movieItem: MovieFeedEntity
    ) : FeedSharedEvent
}