package com.top100.app.presentation.components

import android.view.Surface
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.top100.app.R
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.chip
import com.top100.app.presentation.theme.chips

@Composable
fun AppChip(
    modifier: Modifier = Modifier,
    text: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_4)),
        border = BorderStroke(
            width = 1.dp,
            color = color
        ),
        color = Color.Transparent
    ) {
        Text(
            modifier = Modifier.padding(
                end = dimensionResource(id = R.dimen.size_2),
                start = dimensionResource(id = R.dimen.size_2),
                top = dimensionResource(id = R.dimen.size_1),
                bottom = dimensionResource(id = R.dimen.size_1)
            ),
            text = text,
            color = color,
            style = MaterialTheme.typography.chip
        )
    }
}

@Preview
@Composable
fun AppChipPreview() {
    AppTheme() {
        AppChip(
            text = "Reggeaton",
            color = MaterialTheme.colors.chips

        )
    }
}
