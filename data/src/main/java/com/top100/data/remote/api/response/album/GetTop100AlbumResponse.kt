package com.top100.data.remote.api.response.album

import com.squareup.moshi.Json
import com.top100.data.remote.api.model.album.ApiAlbum

data class GetTop100AlbumResponse(
    @Json(name = "feed")
    var feed: Feed
)
data class Feed(
    @Json(name = "results")
    var results: List<ApiAlbum>
)
