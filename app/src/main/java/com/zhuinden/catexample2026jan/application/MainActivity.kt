package com.zhuinden.catexample2026jan.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.zhuinden.catexample2026jan.application.theme.CatExample2026JanTheme
import com.zhuinden.catexample2026jan.features.detail.DetailScreen
import com.zhuinden.catexample2026jan.features.detail.DetailViewModel
import com.zhuinden.catexample2026jan.features.main.MainScreen
import com.zhuinden.catexample2026jan.features.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            CatExample2026JanTheme {
                NavHost(navController = navController, startDestination = "main") {
                    composable(route = "main") {
                        val viewModel = hiltViewModel<MainViewModel>()

                        LaunchedEffect(Unit) {
                            withContext(Dispatchers.Main.immediate) {
                                viewModel.navigationEvents.collectLatest { event ->
                                    event.invoke(navController)
                                }
                            }
                        }

                        val state by viewModel.state.collectAsStateWithLifecycle()

                        MainScreen(
                            state = state,
                            onButtonClicked = viewModel::onButtonClicked,
                        )
                    }
                    composable(
                        route = "detail/{catId}/{catUrl}",
                        arguments = listOf(
                            navArgument("catId") {
                                type = NavType.StringType
                                nullable = false
                            },
                            navArgument("catUrl") {
                                type = NavType.StringType
                                nullable = false
                            }
                        ),
                    ) {
                        val viewModel = hiltViewModel<DetailViewModel>()

                        val state by viewModel.state.collectAsStateWithLifecycle()

                        DetailScreen(
                            state = state,
                        )
                    }
                }
            }
        }
    }
}
