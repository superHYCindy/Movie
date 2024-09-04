package com.superheeyoung.movie.ui.components.dialog.components.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastForEachIndexed
import com.superheeyoung.movie.ui.components.buttons.PrimaryButton
import com.superheeyoung.movie.ui.components.buttons.SecondaryBorderlessButton
import com.superheeyoung.movie.ui.components.buttons.SecondaryButton
import com.superheeyoung.movie.ui.components.buttons.UnderlinedTextButton
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.theme.Paddings

@Composable
fun DialogButtonColumn(
    buttons : List<DialogButton>?
) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        buttons?.fastForEachIndexed { index, dialogButton ->
            if(index > 0) {
                Spacer(modifier = Modifier.height(Paddings.large))
            }
            when(dialogButton) {
                is DialogButton.Primary -> {
                    PrimaryButton(
                        text = dialogButton.title,
                        leadingIconData = dialogButton.leadingIconData)
                    {
                        dialogButton.action?.invoke()
                    }
                }

                is DialogButton.Secondary -> {
                    SecondaryButton(
                        text = dialogButton.title,
                        )
                    {
                        dialogButton.action?.invoke()
                    }
                }
                is DialogButton.SecondaryBorderless -> {
                    SecondaryBorderlessButton(
                        text = dialogButton.title,
                        )
                    {
                        dialogButton.action?.invoke()
                    }
                }
                is DialogButton.UnderlinedText -> {
                    UnderlinedTextButton(
                        text = dialogButton.title
                    )
                    {
                        dialogButton.action?.invoke()
                    }
                }
            }
        }
        
    }
}