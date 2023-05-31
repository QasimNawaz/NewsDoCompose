package com.qasimnawaz019.newsdocompose.ui.screens.search

import android.content.Intent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.utils.rememberFlowWithLifecycle
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.components.item.NewsRowItem

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    onDetailClick: (article: Article?) -> Unit, viewModel: SearchViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val userSearchModelState by rememberFlowWithLifecycle(viewModel.newsSearchModelState).collectAsState(
        initial = NewsSearchModelState.Empty
    )
    val intent = remember { Intent(Intent.ACTION_SEND) }

    Scaffold(
        backgroundColor = NewsDoComposeTheme.colors.surface, modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        SearchBarUI(innerPadding = innerPadding,
            userSearchModelState.news,
            searchText = userSearchModelState.searchText,
            placeholderText = "Search News",
            onSearchTextChanged = { viewModel.onSearchTextChanged(it) },
            onClearClick = { viewModel.onClearClick() }) { list ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = 3.dp, vertical = 3.dp
                    ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(items = list, key = { it.uuid }) { article ->
                    NewsRowItem(news = article,
                        onDetailClick = { onDetailClick.invoke(article) },
                        onActionClick = { action ->
                            when (action) {
                                R.drawable.ic_share -> {
                                    intent.type = "text/plain"
                                    intent.putExtra(Intent.EXTRA_SUBJECT, "NewsDoCompose")
                                    intent.putExtra(Intent.EXTRA_TEXT, "${article.url}")
                                    context.startActivity(intent)
                                }

                                R.drawable.ic_bookmark -> {
                                    val index = list.indexOf(article)
                                    list[index] = list[index].copy(isFavourite = true)
                                    list[index].isFavourite = true
                                    viewModel.addToBookmark(list[index])
                                }

                                R.drawable.ic_bookmark_fill -> {
                                    val index = list.indexOf(article)
                                    list[index] = list[index].copy(isFavourite = false)
                                    list[index].isFavourite = false
                                    viewModel.removeNewsFromDb(list[index])
                                }
                            }
                        })
                }
            }
        }
    }
}