package com.top100.app.presentation.screens.albums.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.top100.app.presentation.model.PAlbum
import com.top100.app.presentation.model.toPresentation
import com.top100.domain.usecase.album.GetAlbumById
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(
    private val getAlbumById: GetAlbumById
) : ViewModel() {

    private val _album: MutableStateFlow<PAlbum?> = MutableStateFlow(null)
    val album: StateFlow<PAlbum?> = _album.asStateFlow()

    fun getAlbumById(albumId: String) {
        viewModelScope.launch {
            _album.value = getAlbumById.invoke(albumId)?.toPresentation()
        }
    }
}
