package com.top100.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.top100.app.presentation.components.AppLoading
import com.top100.app.presentation.navigation.NavGraphDestination.AlbumsNavGraph
import com.top100.app.presentation.navigation.graphs.addAlbumsNavGraph
import com.top100.app.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            navController = rememberNavController()
            AppTheme {
                AlbumsComposeApp(navController = navController)
            }
        }
    }
}

@Composable
private fun AlbumsComposeApp(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
) {
    val loadingState = remember { mutableStateOf(false) }

    Scaffold(
        scaffoldState = scaffoldState
    ) { innerPadding ->
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            NavHost(
                navController = navController,
                startDestination = AlbumsNavGraph.route,
                modifier = Modifier.padding(innerPadding),
            ) {
                addAlbumsNavGraph(
                    navController = navController,
                    loadingState
                )
            }
            AppLoading(isLoading = loadingState.value)
        }
    }
}

@Preview
@Composable
fun AlbumsComposeAppPreview() {
    AppTheme {
        AlbumsComposeApp()
    }
}
