package com.top100.app.presentation.screens.albums.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.top100.app.presentation.model.PAlbum
import com.top100.app.presentation.model.failure.AlbumFailure
import com.top100.app.presentation.model.toPresentation
import com.top100.common.failure.LayerFailure
import com.top100.common.failure.LayerFailure.DataFailure
import com.top100.domain.usecase.album.FetchTop100Albums
import com.top100.domain.usecase.album.ObserveAlbums
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.mapNotNull
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class AlbumsViewModel @Inject constructor(
    private val fetchTop100Albums: FetchTop100Albums,
    private val observeAlbums: ObserveAlbums
) : ViewModel() {

    private val _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _error: MutableStateFlow<LayerFailure.FeatureFailure?> = MutableStateFlow(null)
    val error: StateFlow<LayerFailure.FeatureFailure?> = _error

    var albums: StateFlow<List<PAlbum>> = MutableStateFlow(listOf())

    init {
        fetchAlbums()
    }

    private fun fetchAlbums() {
        _isLoading.value = true
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    albums = observeAlbums()
                        .mapNotNull { it.map { album -> album.toPresentation() } }
                        .stateIn(this)
                    fetchTop100Albums()
                    albums.collectLatest {
                        _isLoading.value = false
                    }
                } catch (failure: DataFailure) {
                    _isLoading.value = false
                    _error.value =
                        if (albums.value.isEmpty()) {
                            AlbumFailure.FetchAlbumsFailure
                        } else {
                            null
                        }
                }
            }
        }
    }

    fun retry() {
        _isLoading.value = true
        _error.value = null
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                runCatching {
                    fetchTop100Albums()
                }.onSuccess {
                    _isLoading.value = false
                }.onFailure {
                    _isLoading.value = false
                    _error.value = AlbumFailure.FetchAlbumsFailure
                }
            }
        }
    }
}
