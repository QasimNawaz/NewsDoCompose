package com.qasimnawaz019.data.repository.dataSourceImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.qasimnawaz019.data.db.NewsDao
import com.qasimnawaz019.data.remote.WebService
import com.qasimnawaz019.data.repository.dataSource.NewsPagingSource
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.repository.NewsRemoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val webService: WebService,
    private val dataStoreRepository: DataStoreRepository,
    private val newsDao: NewsDao
) : NewsRemoteRepository {

    override fun getNews(category: String): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 3),
            pagingSourceFactory = {
                NewsPagingSource(
                    category = category,
                    webService = webService,
                    dataStoreRepository = dataStoreRepository,
                    newsDao = newsDao
                )
            },
        ).flow
    }

}