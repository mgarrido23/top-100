package com.top100.app.presentation.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.top100.app.R
import com.top100.app.presentation.theme.bigTitleList
import com.top100.app.presentation.theme.littleTitleList
import com.top100.app.presentation.theme.translucent80White

@Composable
fun AppScrollableToolBar(
    title: String,
    modifier: Modifier = Modifier,
    scrollUpState: MutableState<Boolean>,
) {
    var horizontalBias by remember { mutableStateOf(-1f) }
    horizontalBias = if (scrollUpState.value) -1f else 0f
    val alignment by animateHorizontalAlignmentAsState(horizontalBias)
    Surface(
        color = if (scrollUpState.value) {
            MaterialTheme.colors.background
        } else {
            MaterialTheme.colors.translucent80White
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(dimensionResource(id = R.dimen.app_bar_height)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = alignment
        ) {
            Text(
                modifier = Modifier.padding(horizontal = dimensionResource(id = R.dimen.size_4)),
                style = if (scrollUpState.value) {
                    MaterialTheme.typography.bigTitleList
                } else {
                    MaterialTheme.typography.littleTitleList
                },
                text = title
            )
        }
    }
}

@Composable
private fun animateHorizontalAlignmentAsState(
    targetBiasValue: Float
): State<BiasAlignment.Horizontal> {
    val bias by animateFloatAsState(targetBiasValue)
    return derivedStateOf { BiasAlignment.Horizontal(bias) }
}
