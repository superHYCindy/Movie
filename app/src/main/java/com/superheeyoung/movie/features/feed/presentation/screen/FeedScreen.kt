package com.superheeyoung.movie.features.feed.presentation.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.superheeyoung.movie.R
import com.superheeyoung.movie.features.common.entity.MovieResultEntity
import com.superheeyoung.movie.features.feed.presentation.input.FeedViewModelInput
import com.superheeyoung.movie.features.feed.presentation.output.FeedState
import com.superheeyoung.movie.ui.components.movie.CategoryRow
import com.superheeyoung.movie.ui.theme.Paddings

val COMMON_HORIZONTAL_PADDING = Paddings.medium

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FeedScreen(
    feedStateHolder: State<FeedState>,
    input: FeedViewModelInput
) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                modifier = Modifier
                    .background(MaterialTheme.colors.primarySurface)
                    .requiredHeight(70.dp),
                title = {
                    Text(
                        modifier = Modifier.padding(
                            start = COMMON_HORIZONTAL_PADDING
                        ),
                        text = stringResource(id = R.string.app_name),
                        style = MaterialTheme.typography.h3
                    )
                },
                actions = {
                    AppBarMenu(
                        btnColor = Color.Red,
                    //    changeAppColor = changeAppColor,
                        input = input
                    )
                }
            )
        }
    ) {
        BodyContent(
            feedState = feedStateHolder.value,
            input = input
        )
    }
}

@Composable
fun AppBarMenu(
    btnColor: Color,
   // changeAppColor: () -> Unit,
    input: FeedViewModelInput
) {
    Row(
        modifier = Modifier.padding(
            end = COMMON_HORIZONTAL_PADDING
        )
    ) {
        Row(
            modifier = Modifier.padding(
                end = COMMON_HORIZONTAL_PADDING
            )
        ) {
            IconButton(
                onClick = {
                    //changeAppColor()
                }
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(color = btnColor)
                )
            }

            IconButton(
                onClick = {
                    input.openInfoDialog()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_information),
                    contentDescription = "information",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
    }
}

@Composable
fun BodyContent(
    feedState: FeedState,
    input: FeedViewModelInput
) {
    when (feedState) {
        is FeedState.Failed -> {
            RetryMessage(
                message = feedState.reason,
                input = input
            )
        }

        is FeedState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

        is FeedState.Main -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(feedState.movieList) { _, movie ->
                    CategoryRow(
                        movie,
                        input
                    )
                }
            }
        }
    }
}

val IMAGE_SIZE = 48.dp

@Composable
fun RetryMessage(
    modifier: Modifier = Modifier,
    message: String,
    input: FeedViewModelInput
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            modifier = Modifier
                .requiredSize(IMAGE_SIZE),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_warning),
            contentDescription = null
        )
        Text(
            text = message,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(
                top = Paddings.xlarge,
                bottom = Paddings.extra
            )
        )
        Button(onClick = { input.refreshFeed() }) {
            Text("RETRY")
        }
    }
}