package com.superheeyoung.movie.ui.theme

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.superheeyoung.movie.ui.theme.color.ColorSet


private val LocalColors = staticCompositionLocalOf { ColorSet.Red.LightColors }


@Composable
fun MovieTheme(
    myColors: ColorSet = ColorSet.Red,
    typography: Typography = Typography,
    shapes : Shapes = Shapes,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if(darkTheme) {
        myColors.DarkColors
    } else {
        myColors.LightColors
    }

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colors = colors.material,
            typography = Typography,
            content = content
        )
    }
}
