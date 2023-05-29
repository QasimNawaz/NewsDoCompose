package com.qasimnawaz019.newsdocompose.graphs

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.BottomBarScreenInfo
import com.qasimnawaz019.newsdocompose.ui.screens.country.SelectCountryScreen
import com.qasimnawaz019.newsdocompose.ui.screens.details.DetailsScreen
import com.qasimnawaz019.newsdocompose.ui.screens.favourite.FavouriteScreen
import com.qasimnawaz019.newsdocompose.ui.screens.home.HomeScreen
import com.qasimnawaz019.newsdocompose.ui.screens.profile.ProfileScreen
import com.qasimnawaz019.newsdocompose.ui.screens.search.SearchScreen
import com.qasimnawaz019.newsdocompose.ui.screens.categories.ChooseTopicsScreen

@Composable
fun HomeNavigationGraph(
    navController: NavHostController,
    startDestination: String,
    innerPadding: PaddingValues,
) {
    NavHost(
        navController = navController,
        route = Graph.MAIN,
        startDestination = startDestination,
        modifier = Modifier.padding(innerPadding)
    ) {

        composable(route = SelectableScreenInfo.Country.route) {
            SelectCountryScreen(navController)
        }

        composable(route = SelectableScreenInfo.Topics.route) {
            ChooseTopicsScreen(navController)
        }

        composable(route = BottomBarScreenInfo.Home.route) {
            HomeScreen(onDetailClick = {
                it.let { article ->
                    navController.navigate("${Graph.DETAILS}/${article?.uuid}")
                }
            })
        }

        composable(route = BottomBarScreenInfo.Search.route) {
            SearchScreen(onDetailClick = {
                it.let { article ->
                    navController.navigate("${Graph.DETAILS}/${article?.uuid}")
                }
            })
        }

        composable(route = BottomBarScreenInfo.Favourite.route) {
            FavouriteScreen(onDetailClick = {
                it.let { article ->
                    navController.navigate("${Graph.DETAILS}/${article?.uuid}")
                }
            })
        }

        composable(route = BottomBarScreenInfo.Profile.route) {
            ProfileScreen()
        }

        detailsNavigationGraph(navController = navController)
    }
}

fun NavGraphBuilder.detailsNavigationGraph(navController: NavHostController) {
    navigation(
        route = "${Graph.DETAILS}/{article}",
        startDestination = DetailsScreenInfo.Information.route,
        arguments = listOf(navArgument("article") {
            type = NavType.StringType
        })
    ) {
        composable(
            route = DetailsScreenInfo.Information.route,
        ) { navBackStackEntry ->
            val parentEntry =
                remember(navBackStackEntry) { navController.getBackStackEntry("${Graph.DETAILS}/{article}") }
            parentEntry.arguments?.getString("article")
                ?.let {
                    DetailsScreen(uuid = it)
                }
        }
    }
}

sealed class DetailsScreenInfo(val route: String) {
    object Information : DetailsScreenInfo(route = "INFORMATION")
}

sealed class SelectableScreenInfo(val route: String) {
    object Country : DetailsScreenInfo(route = "SELECT_COUNTRY")
    object Topics : DetailsScreenInfo(route = "CHOOSE_TOPICS")
}