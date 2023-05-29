package com.qasimnawaz019.newsdocompose.ui.screens.home.listing

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.ui.components.item.NewsRowItem
import com.qasimnawaz019.newsdocompose.ui.components.item.NewsRowItemShimmerEffect

@Composable
fun NewsListingScreen(
    query: String,
    viewModel: NewsViewModel = hiltViewModel(),
    onDetailClick: (article: Article?) -> Unit,
) {

    val list = viewModel.getNews(query).collectAsLazyPagingItems()
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_SEND) }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 3.dp, vertical = 3.dp
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(items = list, key = { it.uuid }) { article ->
            NewsRowItem(news = article, onDetailClick = {
                onDetailClick.invoke(article)
            }, onActionClick = { action ->
                when (action) {
                    R.drawable.ic_share -> {
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_SUBJECT, "NewsDoCompose")
                        intent.putExtra(Intent.EXTRA_TEXT, "${article?.url}")
                        context.startActivity(intent)
                    }

                    R.drawable.ic_bookmark -> {
                        val index = list.itemSnapshotList.indexOf(article)
                        list.itemSnapshotList[index]?.let {
                            viewModel.addToBookmark(it)
                            list.refresh()
                        }
                    }

                    R.drawable.ic_bookmark_fill -> {
                        val index = list.itemSnapshotList.indexOf(article)
                        list.itemSnapshotList[index]?.let {
                            viewModel.removeNewsFromDb(it)
                            list.refresh()
                        }
                    }
                }
            })
        }

        when (val state = list.loadState.append) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                Loading()
            }

            is LoadState.Error -> {
                Error(message = state.error.message ?: "")
            }
        }
        when (val state = list.loadState.prepend) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                Loading()
            }

            is LoadState.Error -> {
                Error(message = state.error.message ?: "")
            }
        }
        when (val state = list.loadState.refresh) {
            is LoadState.NotLoading -> Unit
            is LoadState.Loading -> {
                for (i in 1..3) {
                    Loading()
                }
            }

            is LoadState.Error -> {
                Error(message = state.error.message ?: "")
            }
        }
    }
}

private fun LazyListScope.Loading() {
    item {
        NewsRowItemShimmerEffect()
    }
}

private fun LazyListScope.Error(
    message: String
) {
    item {
        Text(
            text = message, style = MaterialTheme.typography.h6, color = MaterialTheme.colors.error
        )
    }
}