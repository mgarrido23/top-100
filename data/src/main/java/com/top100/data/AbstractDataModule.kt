package com.top100.data

import com.top100.data.datasource.album.AlbumLocalDataSourceImpl
import com.top100.data.datasource.album.AlbumRemoteDataSourceImpl
import com.top100.data.local.preferences.AppSharedPreferences
import com.top100.data.local.preferences.AppSharedPreferencesImpl
import com.top100.domain.datasource.album.AlbumLocalDataSource
import com.top100.domain.datasource.album.AlbumRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AbstractDataModule {

    // region Local

    @Binds
    @Singleton
    abstract fun bindAppSharedPreferences(
        appSharedPreferencesImpl: AppSharedPreferencesImpl
    ): AppSharedPreferences

    // endregion

    // region Data Sources

    @Binds
    @Singleton
    abstract fun bindAlbumRemoteDataSource(
        albumRemoteDataSource: AlbumRemoteDataSourceImpl
    ): AlbumRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindAlbumLocalDataSource(
        albumLocalDataSource: AlbumLocalDataSourceImpl
    ): AlbumLocalDataSource
    // endregion
}
