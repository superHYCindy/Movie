package com.superheeyoung.movie.features.detail.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.superheeyoung.movie.R
import com.superheeyoung.movie.features.common.entity.MovieFeedEntity
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedEvent
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedViewModel
import com.superheeyoung.movie.ui.theme.MovieTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {
    private val sharedViewModel: FeedSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieTheme {
                    //val movieItem by sharedViewModel.event.collectAsState(initial = null)
                    MovieDetailScreen(sharedViewModel)
                }
            }
        }
    }

    private fun initViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.event.flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collectLatest { state ->
                when(state) {
                    is FeedSharedEvent.SelectFeedItem -> {
                        Log.d("debug111",state.movieItem.toString())
                    }
                }
            }
        }
    }
}