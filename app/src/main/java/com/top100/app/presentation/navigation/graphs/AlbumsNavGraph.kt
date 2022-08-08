package com.top100.app.presentation.navigation.graphs

import androidx.compose.runtime.MutableState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.top100.app.presentation.navigation.NavGraphDestination.AlbumDetailScreen
import com.top100.app.presentation.navigation.NavGraphDestination.AlbumsNavGraph
import com.top100.app.presentation.navigation.NavGraphDestination.AlbumsScreen
import com.top100.app.presentation.screens.albums.detail.AlbumsDetailScreen
import com.top100.app.presentation.screens.albums.list.AlbumsScreen

fun NavGraphBuilder.addAlbumsNavGraph(
    navController: NavHostController,
    loadingState: MutableState<Boolean>
) {
    navigation(
        route = AlbumsNavGraph.route,
        startDestination = AlbumsScreen.route
    ) {
        composable(
            route = AlbumsScreen.route
        ) {
            AlbumsScreen(
                viewModel = hiltViewModel(),
                loadingState = loadingState,
                onViewAlbumDetail = {
                    navController.navigate(
                        AlbumDetailScreen.buildRoute(albumId = it)
                    )
                }
            )
        }

        composable(
            route = AlbumDetailScreen.route,
            arguments = AlbumDetailScreen.arguments
        ) {
            val albumId = it.arguments
                ?.getString(AlbumDetailScreen.ARG_ALBUM_ID)
                .orEmpty()
            AlbumsDetailScreen(
                viewModel = hiltViewModel(),
                albumId = albumId,
                onBackPress = {
                    navController.navigateUp()
                }
            )
        }
    }
}
