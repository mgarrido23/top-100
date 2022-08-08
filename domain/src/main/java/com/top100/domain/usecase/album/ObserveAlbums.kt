package com.top100.domain.usecase.album

import com.top100.domain.repository.AlbumRepository
import javax.inject.Inject

class ObserveAlbums @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    operator fun invoke() = albumRepository.observeAlbums()
}
