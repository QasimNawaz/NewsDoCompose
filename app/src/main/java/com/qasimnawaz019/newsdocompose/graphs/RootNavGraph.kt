package com.qasimnawaz019.newsdocompose.graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.qasimnawaz019.newsdocompose.ui.screens.MainScreen

@Composable
fun RootNavigationGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController, route = Graph.ROOT, startDestination = Graph.SPLASH
    ) {
        splashNavigationGraph(navController = navController)
        authNavigationGraph(navController = navController, startDestination = startDestination)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}

object Graph {
    const val ROOT = "root_graph"
    const val SPLASH = "splash_graph"
    const val AUTH = "auth_graph"
    const val MAIN = "main_graph"
    const val DETAILS = "details_graph"
}