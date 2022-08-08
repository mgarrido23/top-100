package com.top100.data.local.db.model

import com.top100.domain.model.album.Album
import com.top100.domain.model.album.Genre
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class AlbumEntity : RealmObject {
    @PrimaryKey
    var id: String = ""
    var artistId: String = ""
    var artistName: String = ""
    var artistUrl: String = ""
    var artworkUrl100: String = ""
    var contentAdvisoryRating: String = ""
    var genres: RealmList<GenreEntity>? = null
    var kind: String = ""
    var name: String = ""
    var releaseDate: String = ""
    var url: String = ""
}

class GenreEntity : RealmObject {
    var genreId: String = ""
    var name: String = ""
    var url: String = ""
}

fun AlbumEntity.toDomain() = Album(
    artistId = artistId,
    artistName = artistName,
    artistUrl = artistUrl,
    artworkUrl100 = artworkUrl100,
    contentAdvisoryRating = contentAdvisoryRating,
    genres = genres?.map { it.toDomain() } ?: emptyList(),
    id = id,
    kind = kind,
    name = name,
    releaseDate = releaseDate,
    url = url
)

fun Album.toEntity(): AlbumEntity {
    val album = this
    return AlbumEntity().apply {
        id = album.id
        artistId = album.artistId
        artistName = album.artistName
        name = album.name
        url = album.url
        artistUrl = album.artistUrl
        artworkUrl100 = album.artworkUrl100
        contentAdvisoryRating = album.contentAdvisoryRating
        kind = album.kind
        releaseDate = album.releaseDate
        val genresList = album.genres.map {
            GenreEntity().apply {
                genreId = it.genreId
                url = it.url
                name = it.name
            }
        }.toTypedArray()
        genres = realmListOf(*genresList)
    }
}

fun GenreEntity.toDomain() = Genre(
    genreId = genreId,
    name = name,
    url = url
)
