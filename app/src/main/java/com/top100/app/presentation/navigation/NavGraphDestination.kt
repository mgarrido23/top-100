package com.top100.app.presentation.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavGraphDestination {
    abstract val route: String
    open val arguments: List<NamedNavArgument> = emptyList()

    object AlbumsNavGraph : NavGraphDestination() {
        override val route: String = "albums_nav_graph"
    }

    object AlbumsScreen : NavGraphDestination() {
        override val route: String = "albums"
    }

    object AlbumDetailScreen : NavGraphDestination() {
        private const val BASE_PATH = "album"
        const val ARG_ALBUM_ID = "album_id"
        override val route: String = "$BASE_PATH/{$ARG_ALBUM_ID}"

        override val arguments: List<NamedNavArgument> = listOf(
            navArgument(name = ARG_ALBUM_ID) { type = NavType.StringType }
        )

        fun buildRoute(albumId: String): String {
            return "$BASE_PATH/$albumId"
        }
    }
}
