package com.superheeyoung.movie.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.superheeyoung.movie.ui.components.dialog.components.button.DialogButtonColumn
import com.superheeyoung.movie.ui.components.dialog.components.content.DialogContentWrapper
import com.superheeyoung.movie.ui.components.dialog.components.title.DialogTitleWrapper
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.models.dialog.DialogContent
import com.superheeyoung.movie.ui.models.dialog.DialogText
import com.superheeyoung.movie.ui.models.dialog.DialogTitle
import com.superheeyoung.movie.ui.theme.MovieTheme
import com.superheeyoung.movie.ui.theme.Paddings
import com.superheeyoung.movie.ui.theme.colorScheme

@Composable
fun BaseDialogPopup(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = Paddings.none,
        backgroundColor = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(dialogTitle)
                Column(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .fillMaxWidth()
                        .padding(
                            start = Paddings.xlarge,
                            end = Paddings.xlarge,
                            bottom = Paddings.xlarge
                        )
                ) {
                    dialogContent?.let {
                        DialogContentWrapper(dialogContent)
                    }
                    buttons?.let {
                        buttons?.let {
                            DialogButtonColumn(it)
                        }
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun BaseDialogPopupPreview() {
    MovieTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Large(
                DialogText.Default("This is content message")
            ),
            buttons = listOf(
                DialogButton.Primary("Ok") {}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreView2() {
    MovieTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Large(
                DialogText.Default("This is content message")
            ),
            buttons = listOf(
                DialogButton.Secondary("Ok") {},
                DialogButton.UnderlinedText("Cancel") {}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogPopupPreView3() {
    MovieTheme {
        BaseDialogPopup(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent = DialogContent.Rating(
                DialogText.Rating(
                    text = "Rating",
                    rating = 4.0f
                )
            ),
            buttons = listOf(
                DialogButton.Primary("Ok") {},
                DialogButton.Secondary("Cancel") {}
            )
        )
    }
}