package com.qasimnawaz019.newsdocompose.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.OnBoardingScreen
import com.qasimnawaz019.newsdocompose.ui.screens.auth.ForgotPasswordScreen
import com.qasimnawaz019.newsdocompose.ui.screens.auth.LoginScreen
import com.qasimnawaz019.newsdocompose.ui.screens.auth.SignUpScreen
import com.qasimnawaz019.newsdocompose.ui.screens.onboarding.OnBoardingScreen

fun NavGraphBuilder.authNavigationGraph(
    navController: NavHostController,
    startDestination: String
) {
    navigation(
        route = Graph.AUTH, startDestination = startDestination
    ) {

        composable(route = OnBoardingScreen.Welcome.route) {
            OnBoardingScreen(onBoardingCompleted = {
                navController.popBackStack()
                navController.navigate(route = AuthScreenInfo.Login.route)
            })
        }

        composable(route = AuthScreenInfo.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AuthScreenInfo.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(route = AuthScreenInfo.ForgotPassword.route) {
            ForgotPasswordScreen(navController)
        }
    }
}

sealed class AuthScreenInfo(val route: String) {
    object Login : SplashScreenInfo(route = "LOGIN")
    object SignUp : SplashScreenInfo(route = "SIGNUP")
    object ForgotPassword : SplashScreenInfo(route = "FORGOT_PASSWORD")
}