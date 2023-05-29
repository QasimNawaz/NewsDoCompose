package com.qasimnawaz019.domain.repository

import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.NewsApiResponse
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun searchNews(query: String): Flow<ApiResponse<NewsApiResponse?>>

}