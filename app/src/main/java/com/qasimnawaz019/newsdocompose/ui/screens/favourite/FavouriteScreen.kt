package com.qasimnawaz019.newsdocompose.ui.screens.favourite

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.R
import com.qasimnawaz019.newsdocompose.ui.components.item.NewsRowItem


@Composable
fun FavouriteScreen(
    viewModel: FavouriteViewModel = hiltViewModel(),
    onDetailClick: (article: Article?) -> Unit,
) {

    val context = LocalContext.current
    val articles = viewModel.articles
    val intent = remember { Intent(Intent.ACTION_SEND) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 3.dp, vertical = 3.dp
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(items = articles, key = { it.uuid }) { article ->
            NewsRowItem(news = article, onDetailClick = {
                onDetailClick.invoke(article)
            }, onActionClick = { action ->
                when (action) {
                    R.drawable.ic_share -> {
                        intent.type = "text/plain"
                        intent.putExtra(Intent.EXTRA_SUBJECT, "NewsDoCompose")
                        intent.putExtra(Intent.EXTRA_TEXT, "${article.url}")
                        context.startActivity(intent)
                    }

                    R.drawable.ic_bookmark_fill -> {
                        val index = articles.indexOf(article)
                        viewModel.removeNewsFromDb(articles[index])
                    }
                }
            })
        }
    }
}