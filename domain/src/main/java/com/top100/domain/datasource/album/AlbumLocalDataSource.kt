package com.top100.domain.datasource.album

import com.top100.domain.model.album.Album
import kotlinx.coroutines.flow.Flow

interface AlbumLocalDataSource {

    fun observeAlbums(): Flow<List<Album>>
    suspend fun getAlbumById(albumId: String): Album?

    suspend fun restoreAlbums(albums: List<Album>)
}
