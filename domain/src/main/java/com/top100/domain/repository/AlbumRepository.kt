package com.top100.domain.repository

import com.top100.domain.datasource.album.AlbumLocalDataSource
import com.top100.domain.datasource.album.AlbumRemoteDataSource
import com.top100.domain.model.album.Album
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

interface AlbumRepository {
    fun observeAlbums(): Flow<List<Album>>
    suspend fun fetchTop100Albums()
    suspend fun getAlbumById(albumId: String): Album?
}

class AlbumRepositoryImpl @Inject constructor(
    private val albumLocalDataSource: AlbumLocalDataSource,
    private val albumRemoteDataSource: AlbumRemoteDataSource
) : AlbumRepository {

    override fun observeAlbums(): Flow<List<Album>> {
        return albumLocalDataSource.observeAlbums()
    }

    override suspend fun fetchTop100Albums() {
        val albums = albumRemoteDataSource.getTopAlbums()
        albumLocalDataSource.restoreAlbums(albums)
    }

    override suspend fun getAlbumById(albumId: String): Album? =
        albumLocalDataSource.getAlbumById(albumId)
}
