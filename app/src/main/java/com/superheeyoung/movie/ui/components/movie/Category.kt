package com.superheeyoung.movie.ui.components.movie

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
import com.superheeyoung.movie.features.common.network.MovieResponse
import com.superheeyoung.movie.features.common.network.MovieResultResponse
import com.superheeyoung.movie.features.feed.presentation.input.FeedViewModelInput
import com.superheeyoung.movie.ui.theme.MovieTheme
import com.superheeyoung.movie.ui.theme.Paddings

@Composable
fun CategoryRow(
    movie : MovieResultResponse,
    input : FeedViewModelInput

) {
    Column {
        CategoryTitle(movie.title)

        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            //itemsIndexed()
        }
    }
}

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text="Action",
        modifier = Modifier.padding(
            vertical = Paddings.large,
            horizontal = Paddings.extra
        ),
        style = MaterialTheme.typography.h5
    )
}

@Preview
@Composable
fun CategoryRowPreview() {
    MovieTheme {
       // CategoryRow()
    }

}
