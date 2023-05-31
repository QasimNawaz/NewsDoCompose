package com.qasimnawaz019.newsdocompose.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.screens.home.listing.NewsListingScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    onDetailClick: (article: Article?) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val categories = viewModel.categoriesList
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        backgroundColor = NewsDoComposeTheme.colors.surface, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp, horizontal = 2.dp)
                    .background(color = NewsDoComposeTheme.colors.surface),
            ) {
                // Tabs
                ScrollableTabRow(
                    modifier = Modifier.height(35.dp),
                    backgroundColor = NewsDoComposeTheme.colors.surface,
                    selectedTabIndex = pagerState.currentPage,
                    divider = {},
                    indicator = {
                        Box {}
                    },
                ) {
                    categories.forEachIndexed { index, item ->
                        TabItem(coroutineScope, pagerState, index, item)
                    }
                }
            }
            // ViewPager
            HorizontalPager(
                pageCount = categories.size,
                state = pagerState,
            ) {
                NewsListingScreen(
                    query = categories[pagerState.currentPage].replace("\\s".toRegex(), "")
                        .lowercase(),
                    onDetailClick = onDetailClick
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabItem(coroutineScope: CoroutineScope, pagerState: PagerState, index: Int, topic: String) {
    val selected = pagerState.currentPage == index
    Tab(modifier = if (selected) Modifier
        .clip(RoundedCornerShape(50))
        .background(
            brush = Brush.horizontalGradient(
                colors = NewsDoComposeTheme.colors.tabGradient
            )
        )
    else Modifier,
        selected = selected,
        onClick = { coroutineScope.launch { pagerState.animateScrollToPage(index) } },
        text = {
            Text(
                text = topic,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = if (selected) Color.White else NewsDoComposeTheme.colors.textPrimary
            )
        })
}