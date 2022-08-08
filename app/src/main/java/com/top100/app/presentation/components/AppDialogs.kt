package com.top100.app.presentation.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.top100.app.R
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.primaryText
import com.top100.app.presentation.theme.secondaryText

@Composable
fun AppUnimplementedFeatureDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = stringResource(R.string.unimplemented_feature_title),
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.primaryText,
            )
        },
        text = {
            Text(
                text = stringResource(R.string.unimplemented_feature_description),
                color = MaterialTheme.colors.secondaryText,
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(
                    text = stringResource(R.string.ok),
                    color = MaterialTheme.colors.secondary,
                )
            }
        }
    )
}

@Preview
@Composable
fun AppUnimplementedFeatureDialogPreview() {
    AppTheme {
        AppUnimplementedFeatureDialog(onDismiss = {})
    }
}
