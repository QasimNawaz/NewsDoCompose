package com.qasimnawaz019.data.repository.dataSource

import androidx.paging.PagingData
import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.model.NewsApiResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getNews(category: String): Flow<PagingData<Article>>
    suspend fun searchNews(query: String): ApiResponse<NewsApiResponse?>
}