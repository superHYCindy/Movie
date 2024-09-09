package com.superheeyoung.movie.features.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.superheeyoung.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint

class DetailFragment : Fragment() {
    private val args : DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                MovieTheme {
                    Text(text = "DetailFragment")
                }
            }
        }
    }
}