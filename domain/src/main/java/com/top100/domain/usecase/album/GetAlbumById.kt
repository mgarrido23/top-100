package com.top100.domain.usecase.album

import com.top100.domain.repository.AlbumRepository
import javax.inject.Inject

class GetAlbumById @Inject constructor(val albumRepository: AlbumRepository) {
    suspend operator fun invoke(albumId: String) = albumRepository.getAlbumById(albumId)
}
