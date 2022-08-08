package com.top100.data.remote.api.model.album
import com.squareup.moshi.Json
import com.top100.domain.model.album.Album

data class ApiAlbum(
    @Json(name = "artistId")
    var artistId: String = "",
    @Json(name = "artistName")
    var artistName: String = "",
    @Json(name = "artistUrl")
    var artistUrl: String = "",
    @Json(name = "artworkUrl100")
    var artworkUrl100: String = "",
    @Json(name = "contentAdvisoryRating")
    var contentAdvisoryRating: String = "",
    @Json(name = "genres")
    var genres: List<ApiGenre> = listOf(),
    @Json(name = "id")
    var id: String,
    @Json(name = "kind")
    var kind: String = "",
    @Json(name = "name")
    var name: String = "",
    @Json(name = "releaseDate")
    var releaseDate: String = "",
    @Json(name = "url")
    var url: String = ""
) {
    fun toDomain(): Album {
        return Album(
            artistId,
            artistName,
            artistUrl,
            artworkUrl100,
            contentAdvisoryRating,
            genres.map { it.toDomain() },
            id,
            kind,
            name,
            releaseDate,
            url
        )
    }
}
