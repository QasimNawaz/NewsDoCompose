package com.qasimnawaz019.newsdocompose.ui.components.bottombar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.components.NewsDoComposeSurface

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    val screens = listOf(
        BottomBarScreenInfo.Home,
        BottomBarScreenInfo.Search,
        BottomBarScreenInfo.Favourite,
        BottomBarScreenInfo.Profile,
    )

    val navStackBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navStackBackEntry?.destination
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        NewsDoComposeSurface(
            color = NewsDoComposeTheme.colors.bottomBarBackground,
            modifier = Modifier
                .padding(start = 10.dp, top = 6.dp, end = 10.dp, bottom = 16.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(6.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(BottomNavHeight)
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun AddItem(
    screen: BottomBarScreenInfo,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true

    Box(
        modifier = Modifier
            .height(30.dp)
            .clip(CircleShape)
            .background(
                color = if (selected) NewsDoComposeTheme.colors.bottomBarItemColor else Color.Transparent,
            )
            .clickable(onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp),
                painter = painterResource(id = screen.icon),
                contentDescription = "icon",
                tint = Color.White
            )
            AnimatedVisibility(visible = selected) {
                Text(
                    text = screen.title, color = Color.White, fontSize = 11.sp
                )
            }
        }
    }
}

val BottomNavHeight = 46.dp

sealed class BottomBarScreenInfo(
    val route: String, val title: String, val icon: Int
) {
    object Home : BottomBarScreenInfo(
        route = "home", title = "Home", icon = R.drawable.ic_home
    )

    object Search : BottomBarScreenInfo(
        route = "search", title = "Search", icon = R.drawable.ic_search
    )

    object Favourite : BottomBarScreenInfo(
        route = "favourite", title = "Favourite", icon = R.drawable.ic_favourite
    )

    object Profile : BottomBarScreenInfo(
        route = "profile", title = "Profile", icon = R.drawable.ic_profile
    )
}

sealed class OnBoardingScreen(val route: String) {
    object Welcome : OnBoardingScreen(route = "WELCOME")
}