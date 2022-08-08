package com.top100.data.datasource.album

import com.top100.data.local.db.model.AlbumEntity
import com.top100.data.local.db.model.toDomain
import com.top100.data.local.db.model.toEntity
import com.top100.domain.datasource.album.AlbumLocalDataSource
import com.top100.domain.model.album.Album
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import io.realm.kotlin.query.RealmResults
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest

class AlbumLocalDataSourceImpl @Inject constructor(
    private val realm: Realm
) : AlbumLocalDataSource {

    override fun observeAlbums(): Flow<List<Album>> {
        val albumFlow: Flow<ResultsChange<AlbumEntity>> = realm.query<AlbumEntity>().asFlow()
        return albumFlow.mapLatest {
            it.list.map { album -> album.toDomain() }
        }
    }

    override suspend fun getAlbumById(albumId: String): Album? {
        val albums: RealmResults<AlbumEntity> = realm.query<AlbumEntity>().find()
        return albums.findLast { albumModel -> albumModel.id == albumId }?.toDomain()
    }

    override suspend fun restoreAlbums(albums: List<Album>) {
        try {
            realm.write {
                val all: RealmResults<AlbumEntity> = query<AlbumEntity>().find()
                if (albums.isNotEmpty()) {
                    this.delete(all)
                }
                albums.forEach { album ->
                    copyToRealm(album.toEntity())
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }
}
