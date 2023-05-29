package com.qasimnawaz019.newsdocompose.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.qasimnawaz019.newsdocompose.ui.screens.splash.SplashScreen

fun NavGraphBuilder.splashNavigationGraph(navController: NavHostController) {
    navigation(
        route = Graph.SPLASH, startDestination = SplashScreenInfo.Splash.route
    ) {
        composable(route = SplashScreenInfo.Splash.route) {
            SplashScreen(onSplashFinished = {
                navController.popBackStack()
                navController.navigate(Graph.AUTH)
            })
        }
    }
}

sealed class SplashScreenInfo(val route: String) {
    object Splash : SplashScreenInfo(route = "SPLASH")
}