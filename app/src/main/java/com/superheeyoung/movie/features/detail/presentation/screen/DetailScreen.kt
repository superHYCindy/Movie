package com.superheeyoung.movie.features.detail.presentation.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.superheeyoung.movie.R
import com.superheeyoung.movie.features.common.entity.MovieFeedEntity
import com.superheeyoung.movie.features.detail.presentation.input.DetailViewModelInput
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedEvent
import com.superheeyoung.movie.features.feed.presentation.shared.FeedSharedViewModel
import com.superheeyoung.movie.ui.components.movie.MovieMeta
import com.superheeyoung.movie.ui.theme.Paddings

@Composable
fun MovieDetailScreen(
    input: DetailViewModelInput,
    sharedViewModel: FeedSharedViewModel
) {
    //TODO BackHandler
    MovieDetail(
        sharedViewModel,
        input
    )
}


@Composable
fun MovieDetail(
    sharedViewModel: FeedSharedViewModel,
    input: DetailViewModelInput
) {
    var movieItem by remember { mutableStateOf<MovieFeedEntity?>(null) }
    LaunchedEffect(true) {
        sharedViewModel.event.collect { state ->
            when (state) {
                is FeedSharedEvent.SelectFeedItem -> {
                    Log.d("debug32434", state.movieItem.toString())
                    movieItem = state.movieItem
                }
            }
        }
    }

    movieItem?.let {
        MovieScreen(movieItem = it, input)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieScreen(
    movieItem: MovieFeedEntity,
    input: DetailViewModelInput) {
    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                modifier = Modifier.requiredHeight(70.dp),
                navigationIcon = { //뒤로가기
                    IconButton(onClick = { input.goBackToFeed() }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_back),
                            contentDescription = null
                        )
                    }
                },
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 0.dp
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(
                    horizontal = Paddings.extra
                )
                .scrollable(
                    state = scrollState,
                    orientation = Orientation.Vertical
                )
        )
        {
            Row {
                //Poster
                //TODO
                BigPoster(movieItem = movieItem)

                //Meta
                Column(
                    modifier = Modifier.padding(start = Paddings.xlarge)
                ) {
                    /*val id : Int,
                    val posterPath : String,
                    val title : String,
                    val overview : String,
                    val voteAverage : Float*/

                    //Title
                    MovieMeta(
                        key = "Rating",
                        value = movieItem.title
                    )
                }
            }
        }
    }
}

@Composable
fun BigPoster(
    movieItem: MovieFeedEntity
) {
    Card {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest
                    .Builder(LocalContext.current)
                    .data(data = movieItem.posterPath)
                    .apply {
                        crossfade(true)
                        scale(Scale.FILL)
                    }.build()
            ),
            modifier = Modifier
                .width(180.dp)
                .height(250.dp),
            contentScale = ContentScale.FillHeight,
            contentDescription = "Movie PosterPath"
        )
    }
}