package com.top100.app.presentation.model

import android.os.Parcelable
import com.top100.domain.model.album.Genre
import kotlinx.parcelize.Parcelize

@Parcelize
data class PGenre(
    val genreId: String,
    val name: String,
    val url: String
) : Parcelable

fun Genre.toPresentation(): PGenre {
    return PGenre(
        this.genreId,
        this.name,
        this.url
    )
}
