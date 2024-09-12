package com.superheeyoung.movie.features.dialog

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.fragment.app.DialogFragment
import com.superheeyoung.movie.R
import com.superheeyoung.movie.ui.components.dialog.Alert
import com.superheeyoung.movie.ui.components.dialog.DialogPopup
import com.superheeyoung.movie.ui.models.dialog.DialogButton
import com.superheeyoung.movie.ui.theme.MovieTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoDialogFragment : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent { 
                MovieTheme {
                    DialogPopup.Alert(
                        title = stringResource(id = R.string.app_name),
                        bodyText = stringResource(id = R.string.info_message),
                        buttons = listOf(
                            DialogButton.UnderlinedText(getString(R.string.close)){
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}