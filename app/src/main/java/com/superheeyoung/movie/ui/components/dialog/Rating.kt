package com.superheeyoung.movie.ui.components.dialog

import androidx.compose.runtime.Composable
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.models.dialog.DialogContent
import com.superheeyoung.movie.ui.models.dialog.DialogText
import com.superheeyoung.movie.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialogPopup(
        dialogTitle = DialogTitle.Header("Please Rate your Score"),
        dialogContent = DialogContent.Rating(
            DialogText.Rating(
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}