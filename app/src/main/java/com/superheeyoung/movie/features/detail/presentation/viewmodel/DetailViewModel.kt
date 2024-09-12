package com.superheeyoung.movie.features.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superheeyoung.movie.features.detail.presentation.input.DetailViewModelInput
import com.superheeyoung.movie.features.detail.presentation.output.DetailUiEffect
import com.superheeyoung.movie.features.detail.presentation.output.DetailViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel(), DetailViewModelInput,
    DetailViewModelOutput {

    val input: DetailViewModelInput = this
    val output: DetailViewModelOutput = this

    private val _detailUiEffect = MutableSharedFlow<DetailUiEffect>(replay = 0)
    override val detailUiEffect: SharedFlow<DetailUiEffect>
        get() = _detailUiEffect

    override fun goBackToFeed() {
        viewModelScope.launch {
            _detailUiEffect.emit(
                DetailUiEffect.Back
            )
        }
    }

}