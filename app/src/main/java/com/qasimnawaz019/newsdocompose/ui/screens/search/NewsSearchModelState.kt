package com.qasimnawaz019.newsdocompose.ui.screens.search

import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.NewsApiResponse

data class NewsSearchModelState(
    val searchText: String = "",
    val news: ApiResponse<NewsApiResponse?> = ApiResponse.Loading,
    val showProgressBar: Boolean = false
) {

    companion object {
        val Empty = NewsSearchModelState()
    }

}