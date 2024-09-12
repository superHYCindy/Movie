package com.superheeyoung.movie.features.detail.presentation.output

import kotlinx.coroutines.flow.SharedFlow

interface DetailViewModelOutput {
    val detailUiEffect : SharedFlow<DetailUiEffect>
}

sealed class DetailUiEffect {
    object Back : DetailUiEffect()
}