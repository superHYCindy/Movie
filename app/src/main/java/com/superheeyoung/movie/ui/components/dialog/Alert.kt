package com.superheeyoung.movie.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.superheeyoung.movie.R
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.models.dialog.DialogContent
import com.superheeyoung.movie.ui.models.dialog.DialogText
import com.superheeyoung.movie.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
    title: String, bodyText: String, buttons: List<DialogButton>
) {
    BaseDialogPopup(dialogTitle = DialogTitle.Header(title), dialogContent = DialogContent.Large(
        DialogText.Default(
            bodyText
        )
    ), buttons = listOf(DialogButton.Primary("Ok") {}))
}