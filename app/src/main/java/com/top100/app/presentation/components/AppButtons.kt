package com.top100.app.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.top100.app.R
import com.top100.app.presentation.theme.AppTheme
import com.top100.app.presentation.theme.backgroundButton
import com.top100.app.presentation.theme.buttonText
import com.top100.app.presentation.theme.iconBackButtonColor
import com.top100.app.presentation.theme.translucentWhite

@Composable
fun AppLinkButton(
    modifier: Modifier = Modifier,
    @StringRes textResId: Int,
    fontSize: TextUnit = TextUnit.Unspecified,
    onClick: () -> Unit,
) {
    Text(
        text = stringResource(textResId),
        modifier = modifier.then(Modifier.clickable { onClick() }),
        style = MaterialTheme.typography.subtitle1,
        fontSize = fontSize,
        color = MaterialTheme.colors.secondary,
    )
}

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {

    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.backgroundButton
        ),
        shape = RoundedCornerShape(10.dp),
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 13.dp)

    ) {
        Text(
            text = text,
            modifier = modifier.then(Modifier.clickable { onClick() }),
            style = MaterialTheme.typography.buttonText,
            color = Color.White,
        )
    }
}

@Composable
fun AppIconButton(
    @DrawableRes iconResId: Int,
    onClick: () -> Unit,
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(iconResId),
            tint = MaterialTheme.colors.secondary,
            contentDescription = null,
        )
    }
}

@Composable
fun AppBackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .background(
                shape = CircleShape,
                color = MaterialTheme.colors.translucentWhite
            )
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp),
            painter = painterResource(R.drawable.ic_chevron_left),
            tint = MaterialTheme.colors.iconBackButtonColor,
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun AppLinkButtonPreview() {
    AppTheme {
        AppLinkButton(
            textResId = R.string.error_button_text,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun AppIconButtonPreview() {
    AppTheme {
        AppIconButton(
            iconResId = R.drawable.ic_info_circle,
            onClick = {},
        )
    }
}

@Preview
@Composable
fun AppBackButtonPreview() {
    AppTheme {
        AppBackButton(
            onClick = {},
        )
    }
}

@Preview
@Composable
fun AppButtonPreview() {
    AppTheme {
        AppButton(
            text = "Visit the Album",
            onClick = {},
        )
    }
}
