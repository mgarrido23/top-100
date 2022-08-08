package com.top100.app.presentation.screens.albums.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.top100.app.R
import com.top100.app.presentation.components.AppScrollableToolBar
import com.top100.app.presentation.components.ErrorView
import com.top100.app.presentation.model.PAlbum
import com.top100.common.failure.LayerFailure

@Composable
fun AlbumsScreen(
    viewModel: AlbumsViewModel,
    loadingState: MutableState<Boolean>,
    onViewAlbumDetail: (albumId: String) -> Unit
) {
    val viewLoading by viewModel.isLoading.collectAsState()
    val albums by viewModel.albums.collectAsState()
    val error by viewModel.error.collectAsState()

    AlbumsScreenContent(
        albums = albums,
        isLoading = viewLoading,
        error = error,
        loadingState = loadingState,
        onClick = {
            onViewAlbumDetail(it.id)
        },
        errorHandler = {
            viewModel.retry()
        }
    )
}

@Composable
private fun AlbumsScreenContent(
    albums: List<PAlbum>,
    isLoading: Boolean,
    error: LayerFailure.FeatureFailure?,
    loadingState: MutableState<Boolean>,
    modifier: Modifier = Modifier,
    onClick: (PAlbum) -> Unit,
    errorHandler: () -> Unit
) {
    loadingState.value = isLoading
    val scrollState = rememberLazyGridState()
    val scrollUpState = remember { mutableStateOf(true) }
    scrollUpState.value = scrollState.firstVisibleItemIndex == 0

    Box(
        modifier = modifier.fillMaxSize(),
    ) {

        if (error != null) {
            ErrorView(
                isVisible = true,
                errorMessage = stringResource(id = R.string.error_generic_message),
                buttonText = stringResource(id = R.string.error_button_text),
                handlerErrorButton = {
                    errorHandler()
                }
            )
        } else {
            LazyVerticalGrid(
                contentPadding = PaddingValues(
                    top = dimensionResource(id = R.dimen.app_bar_height) +
                        WindowInsets.statusBars.asPaddingValues()
                            .calculateTopPadding(),
                    bottom = WindowInsets.systemBars
                        .only(WindowInsetsSides.Bottom)
                        .asPaddingValues().calculateBottomPadding(),
                    start = dimensionResource(id = R.dimen.size_4),
                    end = dimensionResource(id = R.dimen.size_4)
                ),
                state = scrollState,
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_3)),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_3))
            ) {
                items(items = albums, key = { album -> album.id }) { album ->
                    AlbumItem(
                        album = album,
                        onClick = {
                            onClick(album)
                        }
                    )
                }
            }
        }

        AppScrollableToolBar(
            title = stringResource(id = R.string.albums_toolbar_title),
            scrollUpState = scrollUpState
        )
    }
}
