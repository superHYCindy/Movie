package com.superheeyoung.movie.features.feed.presentation.output

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface FeedViewModelOutput {
    val feedState : StateFlow<FeedState>
    val feedUiEffect : SharedFlow<FeedUiEffect>
}

object FeedState

sealed class FeedUiEffect {
    data class OpenMovieDetail(val movieName : String)
    object OpenInfoDialog : FeedUiEffect()
}
