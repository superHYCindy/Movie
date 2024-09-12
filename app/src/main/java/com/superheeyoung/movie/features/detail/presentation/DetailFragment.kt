package com.superheeyoung.movie.features.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.superheeyoung.movie.features.detail.presentation.output.DetailUiEffect
import com.superheeyoung.movie.features.detail.presentation.screen.MovieDetailScreen
import com.superheeyoung.movie.features.detail.presentation.viewmodel.DetailViewModel
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedViewModel
import com.superheeyoung.movie.ui.theme.MovieTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {
    private val sharedViewModel: FeedSharedViewModel by activityViewModels()

    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeUiEffect()
        return ComposeView(requireContext()).apply {
            setContent {
                MovieTheme {
                    MovieDetailScreen(
                        detailViewModel.input,
                        sharedViewModel
                    )
                }
            }
        }
    }

    private fun observeUiEffect() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                detailViewModel.output.detailUiEffect.collectLatest { effect ->
                    when (effect) {
                        DetailUiEffect.Back -> {
                            findNavController().navigateUp()
                        }
                    }
                }
            }
        }
    }

}