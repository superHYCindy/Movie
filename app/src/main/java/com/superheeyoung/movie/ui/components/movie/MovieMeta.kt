package com.superheeyoung.movie.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.superheeyoung.movie.ui.components.util.getAnnotatedText
import com.superheeyoung.movie.ui.theme.Paddings

@Composable
fun MovieMeta(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {
    Column(
        modifier = modifier
    ) {
        //Key
        Text(
            text = key,
            style = MaterialTheme.typography.h5,
            color = MaterialTheme.colors.onSurface.copy(0.5f)
        )

        //Value
        Text(
            text = getAnnotatedText(text = value),
            style = MaterialTheme.typography.body2
        )

        Spacer(modifier = Modifier.height(Paddings.large))
    }
}