package com.top100.app.presentation.theme

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
val Dark = Color(0xFF111226)
val Grey = Color(0xFF8e8e93)
val SoftGrey = Color(0xFFb5b5b5)
val Blue = Color(0xFF007aff)
val TranslucentWhite = Color(0x80FFFFFF)
val Translucent80White = Color(0xE6FFFFFF)
val DarkBlueGrey = Color(0xFF0A1C24)
val GreyishBrown = Color(0xFF424242)
val Black75 = Color(0xC0000000)
val BlackTransparent = Color(0x00000000)

// region Colors extensions

val Colors.selectedTabText: Color
    get() = if (isLight) Color.White else Color.White

val Colors.primaryText: Color
    get() = if (isLight) DarkBlueGrey else DarkBlueGrey

val Colors.secondaryText: Color
    get() = if (isLight) GreyishBrown else GreyishBrown

val Colors.albumItemText: Color
    get() = if (isLight) Color.White else Color.White

val Colors.albumDetailTitle: Color
    get() = if (isLight) Dark else Dark

val Colors.albumDetailExtraInfo: Color
    get() = if (isLight) SoftGrey else SoftGrey

val Colors.albumDetailCaption: Color
    get() = if (isLight) Grey else Grey

val Colors.errorMessage: Color
    get() = if (isLight) Dark else Dark

val Colors.chips: Color
    get() = Blue

val Colors.backgroundButton: Color
    get() = Blue

val Colors.iconBackButtonColor: Color
    get() = Dark

val Colors.translucentWhite: Color
    get() = TranslucentWhite

val Colors.translucent80White: Color
    get() = Translucent80White

val Colors.black75: Color
    get() = Black75

val Colors.blackTransparent: Color
    get() = BlackTransparent

// endregion
