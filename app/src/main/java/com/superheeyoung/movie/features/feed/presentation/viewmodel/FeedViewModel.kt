package com.superheeyoung.movie.features.feed.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superheeyoung.movie.features.common.entity.BaseEntity
import com.superheeyoung.movie.features.common.repository.MovieRepository
import com.superheeyoung.movie.features.feed.domain.GetMovieListUseCase
import com.superheeyoung.movie.features.feed.presentation.input.FeedViewModelInput
import com.superheeyoung.movie.features.feed.presentation.output.FeedState
import com.superheeyoung.movie.features.feed.presentation.output.FeedUiEffect
import com.superheeyoung.movie.features.feed.presentation.output.FeedViewModelOutput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getMovieListUseCase: GetMovieListUseCase
) : ViewModel(), FeedViewModelOutput, FeedViewModelInput {
    val output: FeedViewModelOutput = this
    val input: FeedViewModelInput = this

    //화면에 보여주기 위한 flow
    private val _feedState: MutableStateFlow<FeedState> =
        MutableStateFlow(FeedState.Loading)
    override val feedState: StateFlow<FeedState>
        get() = _feedState

    //유저로 부터 입력을 받아서 Fragment에서 액션을 수행하기 위해 선언한 flow
    private val _feedUiEffect = MutableSharedFlow<FeedUiEffect>(replay = 0)
    override val feedUiEffect: SharedFlow<FeedUiEffect>
        get() = _feedUiEffect

    override fun openDetail(movieName: String) {
        TODO("Not yet implemented")
    }

    override fun openInfoDialog() {
        TODO("Not yet implemented")
    }

    override fun refreshFeed() {
        TODO("Not yet implemented")
    }

    fun getMovieList() {
        viewModelScope.launch {
            val movieList = getMovieListUseCase()
            _feedState.value = when (movieList) {
                is BaseEntity.Fail -> {
                    FeedState.Failed(movieList.error.message ?: "Unknown Error")
                }

                is BaseEntity.Success -> {
                    FeedState.Main(
                        movieList = movieList.entity
                    )
                }
            }
        }
    }
}