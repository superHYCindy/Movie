package com.superheeyoung.movie.features.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.superheeyoung.movie.R
import com.superheeyoung.movie.features.feed.presentation.navigation.safeNavigate
import com.superheeyoung.movie.features.feed.presentation.output.FeedUiEffect
import com.superheeyoung.movie.features.feed.presentation.screen.FeedScreen
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedEvent
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedViewModel
import com.superheeyoung.movie.features.feed.presentation.viewmodel.FeedViewModel
import com.superheeyoung.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private val feedViewModel: FeedViewModel by viewModels()


    private val sharedViewModel: FeedSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffects()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieTheme {
                    feedViewModel.getMovieList()
                    FeedScreen(
                        feedStateHolder = feedViewModel.output.feedState.collectAsState(),
                        input = feedViewModel.input
                    )
                }
            }
        }
    }

    private fun observeUiEffects() {
        val navController = findNavController()
        viewLifecycleOwner.lifecycleScope.launch {
            feedViewModel.output.feedUiEffect.collectLatest {
                when (it) {
                    is FeedUiEffect.OpenMovieDetail -> {
                        navController.safeNavigate(
                            FeedFragmentDirections.actionFeedToDetail()
                        )
                    }

                    is FeedUiEffect.OpenInfoDialog -> {

                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            feedViewModel.event.collect { event ->
                when (event) {
                    is FeedSharedEvent.SelectFeedItem ->
                        sharedViewModel.updateSelectFeedItem(event.movieItem)
                }
            }
        }
    }
}
