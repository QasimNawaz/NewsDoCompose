package com.qasimnawaz019.domain.repository

import androidx.paging.PagingData
import com.qasimnawaz019.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRemoteRepository {
    fun getNews(category: String): Flow<PagingData<Article>>
}