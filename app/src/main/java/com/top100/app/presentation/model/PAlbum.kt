package com.top100.app.presentation.model

import android.os.Parcelable
import com.top100.app.presentation.extensions.toDate
import com.top100.app.presentation.extensions.toFormattedDate
import com.top100.domain.model.album.Album
import kotlinx.parcelize.Parcelize

@Parcelize
data class PAlbum(
    val artistId: String,
    val artistName: String,
    val artistUrl: String,
    val artworkUrl100: String,
    val contentAdvisoryRating: String,
    val genres: List<PGenre>,
    val id: String,
    val kind: String,
    val name: String,
    val releaseDate: String,
    val url: String
) : Parcelable {

    val artworkUrl400 :String
        get() = artworkUrl100.replace("100x100","400x400")

    val releaseDateFormatted: String
        get() = releaseDate.toDate()?.toFormattedDate() ?: releaseDate
}

fun Album.toPresentation(): PAlbum {
    return PAlbum(
        this.artistId,
        this.artistName,
        this.artistUrl,
        this.artworkUrl100,
        this.contentAdvisoryRating,
        this.genres.map { it.toPresentation() },
        this.id,
        this.kind,
        this.name,
        this.releaseDate,
        this.url
    )
}
