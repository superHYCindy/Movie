package com.superheeyoung.movie.ui.components.dialog

import androidx.compose.runtime.Composable
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.models.dialog.DialogContent
import com.superheeyoung.movie.ui.models.dialog.DialogText
import com.superheeyoung.movie.ui.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default(
    title : String,
    bodyText : String,
    buttons : List<DialogButton>
){
    BaseDialogPopup(
        dialogTitle = DialogTitle.Default(title),
        dialogContent = DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}