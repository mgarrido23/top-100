package com.top100.data.remote.api

import com.top100.data.remote.api.response.album.GetTop100AlbumResponse
import retrofit2.Response
import retrofit2.http.GET

interface AlbumsApiService {

    @GET(TOP_100_ALBUMS)
    suspend fun getTop100Albums(): Response<GetTop100AlbumResponse>

    companion object {
        private const val TOP_100_ALBUMS = "v2/us/music/most-played/100/albums.json"
    }
}
