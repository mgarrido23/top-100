package com.top100.app.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.top100.app.R

val SfproDisplay = FontFamily(
    Font(R.font.sfpro_display_regular, FontWeight.Normal),
    Font(R.font.sfpro_display_medium, FontWeight.Medium),
    Font(R.font.sfpro_display_bold, FontWeight.Bold),

)

val Typography = Typography(
    h4 = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
    ),
    subtitle1 = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    ),
    body1 = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    ),
    body2 = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    caption = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
    ),
)

val Typography.bigTitleList: TextStyle
    get() = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
    )

val Typography.littleTitleList: TextStyle
    get() = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
    )

val Typography.extraInfoAlbumDetail: TextStyle
    get() = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
    )

val Typography.chip: TextStyle
    get() = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )

val Typography.buttonText: TextStyle
    get() = TextStyle(
        fontFamily = SfproDisplay,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )
