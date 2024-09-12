package com.superheeyoung.movie.ui.components.movie

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.superheeyoung.movie.R
import com.superheeyoung.movie.features.common.entity.MovieFeedEntity
import com.superheeyoung.movie.features.feed.data.GenreType
import com.superheeyoung.movie.features.feed.presentation.input.FeedViewModelInput
import com.superheeyoung.movie.ui.theme.Paddings

private val CARD_WIDTH = 150.dp
private val ICON_SIZE = 12.dp

/*@Preview(showBackground = true)
@Composable
fun PreviewMovieItem() {
    MovieItem(
        movie = MovieFeedEntity(
                    id = 365177,
                    posterPath = "https://image.tmdb.org/t/p/w500+/865DntZzOdX6rLMd405R0nFkLmL.jpg",
                    title = "Borderlands",
                    overview = "Returning to her home planet",
                    voteAverage = 5.852.toFloat()
                ),
       // input = null
    )
}*/

@Composable
fun MovieItem(
    movie: MovieFeedEntity,
    input: FeedViewModelInput
) {
    Column(
        modifier = Modifier
            .width(CARD_WIDTH)
            .padding(Paddings.large)
    ) {
        Poster(
            movie,
            input
        )

        Text(
            text = movie.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                top = Paddings.large
            ),
            style = MaterialTheme.typography.body2
        )

        Row(
            modifier = Modifier.padding(
                vertical = Paddings.medium
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(Paddings.small)
                    .size(ICON_SIZE),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_rating),
                tint = Color.Black.copy(
                    alpha = 0.5f
                ),
                contentDescription = "rating icon"
            )

            Text(
                text = "${movie.voteAverage}",
                style = MaterialTheme.typography.body2,
                color = MaterialTheme.colors.onSurface.copy(
                    alpha = 0.5f
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Poster(
    movie: MovieFeedEntity,
    input: FeedViewModelInput
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),
        onClick = {
            input.openDetail(movie)
        }
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(movie.posterPath)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            modifier = Modifier.width(CARD_WIDTH),
            contentDescription = "Movie Poster Image"
        )
    }
}
