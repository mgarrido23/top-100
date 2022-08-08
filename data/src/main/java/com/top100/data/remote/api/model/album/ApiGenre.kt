package com.top100.data.remote.api.model.album

import com.squareup.moshi.Json
import com.top100.domain.model.album.Genre

data class ApiGenre(
    @Json(name = "genreId")
    var genreId: String,
    @Json(name = "name")
    var name: String,
    @Json(name = "url")
    var url: String
) {
    fun toDomain(): Genre {
        return Genre(
            genreId = genreId,
            name = name,
            url = url
        )
    }
}
