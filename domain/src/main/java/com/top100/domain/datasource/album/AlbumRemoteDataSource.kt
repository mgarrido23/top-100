package com.top100.domain.datasource.album

import com.top100.domain.model.album.Album

interface AlbumRemoteDataSource {

    suspend fun getTopAlbums(): List<Album>
}
