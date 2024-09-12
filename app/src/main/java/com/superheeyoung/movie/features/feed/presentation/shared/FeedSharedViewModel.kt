package com.superheeyoung.movie.features.feed.presentation.shared

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superheeyoung.movie.features.common.entity.MovieFeedEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedSharedViewModel @Inject constructor()
    : ViewModel() {
    private val _event = MutableSharedFlow<FeedSharedEvent>(replay = 1)
    val event: SharedFlow<FeedSharedEvent> = _event.asSharedFlow()

    fun updateSelectFeedItem(item: MovieFeedEntity) = viewModelScope.launch {
        Log.d("debug555",item.toString())
        _event.emit(FeedSharedEvent.SelectFeedItem(item))
    }
}