package com.qasimnawaz019.domain.repository

import com.qasimnawaz019.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalRepository {

    suspend fun getNewsFromDB(): Flow<List<Article>>

    suspend fun addNewsToDb(article: Article)

    suspend fun deleteNewsFromDb(uuid: String)

    suspend fun removeNewsFromDB(article: Article)
}