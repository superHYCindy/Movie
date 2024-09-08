package com.superheeyoung.movie.features.feed.presentation.output

import com.superheeyoung.movie.features.feed.presentation.output.FeedState
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface FeedViewModelOutput {
    val feedState : StateFlow<FeedState>
    val feedUiEffect : SharedFlow<FeedUiEffect>
}


sealed class FeedUiEffect {
    data class OpenMovieDetail(val movieName : String)
    object OpenInfoDialog : FeedUiEffect()
}
