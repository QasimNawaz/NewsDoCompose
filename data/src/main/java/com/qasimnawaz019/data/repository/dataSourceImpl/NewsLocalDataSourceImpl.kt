package com.qasimnawaz019.data.repository.dataSourceImpl

import com.qasimnawaz019.data.db.NewsDao
import com.qasimnawaz019.data.di.IoDispatcher
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.repository.NewsLocalRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NewsLocalDataSourceImpl @Inject constructor(
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
    private val newsDao: NewsDao,
) : NewsLocalRepository {

    override suspend fun getNewsFromDB(): Flow<List<Article>> {
        return flow {
            emit(newsDao.getAllNews())
        }.flowOn(dispatcher)
    }

    override suspend fun addNewsToDb(article: Article) = newsDao.addNews(article)

    override suspend fun deleteNewsFromDb(uuid: String) = newsDao.deleteNewsById(uuid)

    override suspend fun removeNewsFromDB(article: Article) = newsDao.deleteNewsFromDB(article)


}