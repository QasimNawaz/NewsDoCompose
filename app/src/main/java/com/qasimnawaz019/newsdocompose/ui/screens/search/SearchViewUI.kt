package com.qasimnawaz019.newsdocompose.ui.screens.search

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.model.NewsApiResponse
import com.qasimnawaz019.newsdocompose.ui.components.SearchBar

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun SearchBarUI(
    innerPadding: PaddingValues,
    response: ApiResponse<NewsApiResponse?>,
    searchText: String,
    placeholderText: String = "",
    onSearchTextChanged: (String) -> Unit = {},
    onClearClick: () -> Unit = {},
    results: @Composable (SnapshotStateList<Article>) -> Unit = {}
) {

    Box(modifier = Modifier.padding(innerPadding)) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            SearchBar(
                searchText, placeholderText, onSearchTextChanged, onClearClick
            )

            when (response) {
                is ApiResponse.Success -> {
                    response.value?.let { data ->
                        results(mutableStateListOf<Article>().apply { addAll(data.articles) })
                    }
                }

                is ApiResponse.Error -> {
                    ResultWithError(response.cause?.message ?: "Something went wrong")
                }

                ApiResponse.Empty -> {
                    ResultWithError("No Results found")
                }

                ApiResponse.Loading -> {
                    Loading()
                }
            }
        }

    }
}


@Composable
fun ResultWithError(error: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(error)

    }
}

@Composable
fun Loading() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        CircularProgressIndicator(modifier = Modifier.padding(16.dp))

    }
}