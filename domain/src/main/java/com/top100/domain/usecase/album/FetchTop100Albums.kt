package com.top100.domain.usecase.album

import com.top100.domain.repository.AlbumRepository
import javax.inject.Inject

class FetchTop100Albums @Inject constructor(
    private val albumRepository: AlbumRepository
) {
    suspend operator fun invoke() = albumRepository.fetchTop100Albums()
}
