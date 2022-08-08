package com.top100.app.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.Blue

@Composable
internal fun AppLoading(
    modifier: Modifier = Modifier,
    isLoading: Boolean
) {
    if (isLoading) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                color = Blue,
                strokeWidth = 4.dp
            )
        }
    }
}

@Preview
@Composable
fun AppLoadingPreview() {
    AppTheme {
        AppLoading(isLoading = true)
    }
}
