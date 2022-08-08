package com.top100.app.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.top100.app.R
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.errorMessage

@Composable
internal fun ErrorView(
    isVisible: Boolean,
    modifier: Modifier = Modifier,
    errorMessage: String,
    buttonText: String,
    handlerErrorButton: () -> Unit = {}
) {
    if (isVisible) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.errorMessage
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_6)))
            AppButton(
                text = buttonText,
                onClick = {
                    handlerErrorButton()
                }
            )
        }
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    AppTheme {
        ErrorView(
            isVisible = true,
            errorMessage = stringResource(id = R.string.error_generic_message),
            buttonText = stringResource(id = R.string.error_button_text),
            handlerErrorButton = {}
        )
    }
}
