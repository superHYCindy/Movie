package com.superheeyoung.movie.ui.components.movie

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.superheeyoung.movie.features.common.entity.MovieResultEntity
import com.superheeyoung.movie.features.common.network.MovieResponse
import com.superheeyoung.movie.features.common.network.MovieResultResponse
import com.superheeyoung.movie.features.feed.presentation.input.FeedViewModelInput
import com.superheeyoung.movie.ui.theme.MovieTheme
import com.superheeyoung.movie.ui.theme.Paddings

@Composable
fun CategoryRow(
    movie: MovieResultEntity,
    input: FeedViewModelInput
) {
    Column {
        CategoryTitle(movie.genreType.name)
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            itemsIndexed(
                movie.movieEntities
            ) { index, item ->
                MovieItem(
                    movie = item,
                    input = input
                )
            }
        }
    }
}

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text = titleName,
        modifier = Modifier.padding(
            vertical = Paddings.large,
            horizontal = Paddings.extra
        ),
        style = MaterialTheme.typography.h5
    )
}
