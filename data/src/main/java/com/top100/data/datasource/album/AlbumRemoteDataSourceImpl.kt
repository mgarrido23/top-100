package com.top100.data.datasource.album

import com.top100.common.api.ApiCallHandler
import com.top100.common.failure.ApiFailure
import com.top100.common.failure.toDataFailure
import com.top100.data.remote.api.AlbumsApiService
import com.top100.domain.datasource.album.AlbumRemoteDataSource
import com.top100.domain.model.album.Album
import javax.inject.Inject

class AlbumRemoteDataSourceImpl @Inject constructor(
    private val apiCallHandler: ApiCallHandler,
    private val albumsApiService: AlbumsApiService
) : AlbumRemoteDataSource {

    override suspend fun getTopAlbums(): List<Album> = try {
        val response = apiCallHandler
            .process(albumsApiService::getTop100Albums)
            .mapCatching { response ->
                response.feed.results.map { it.toDomain() }
            }
        response.getOrThrow()
    } catch (throwable: ApiFailure) {
        throw throwable.toDataFailure()
    }
}
