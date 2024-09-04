package com.superheeyoung.movie.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.theme.MovieTheme

@Preview
@Composable
fun AlertPreview() {
    MovieTheme {
        DialogPopup.Alert(
            title = "Title",
            bodyText = "This is Body Content",
            buttons = listOf(
                DialogButton.UnderlinedText("Ok") {}
            )
        )
    }
}