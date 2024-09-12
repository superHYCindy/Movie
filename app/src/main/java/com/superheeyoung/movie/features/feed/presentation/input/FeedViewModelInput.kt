package com.superheeyoung.movie.features.feed.presentation.input

import com.superheeyoung.movie.features.common.entity.MovieFeedEntity

interface FeedViewModelInput {
    fun openDetail(item : MovieFeedEntity)
    fun openInfoDialog()
    fun refreshFeed()
}