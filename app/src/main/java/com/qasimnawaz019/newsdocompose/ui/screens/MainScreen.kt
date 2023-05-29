package com.qasimnawaz019.newsdocompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.qasimnawaz019.newsdocompose.graphs.HomeNavigationGraph
import com.qasimnawaz019.newsdocompose.ui.components.NewsDoComposeScaffold
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.BottomBar

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
    viewModel: MainScreenViewModel = hiltViewModel()
) {
    NewsDoComposeScaffold(bottomBar = { BottomBar(navController = navController) }) { innerPadding ->
        if (!viewModel.isLoading.value) {
            val screen by viewModel.startDestination
            HomeNavigationGraph(
                navController = navController,
                startDestination = screen,
                innerPadding = innerPadding
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}