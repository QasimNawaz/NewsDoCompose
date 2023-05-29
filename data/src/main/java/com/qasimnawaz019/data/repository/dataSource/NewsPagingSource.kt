package com.qasimnawaz019.data.repository.dataSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.qasimnawaz019.data.BuildConfig
import com.qasimnawaz019.data.db.NewsDao
import com.qasimnawaz019.data.remote.WebService
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.domain.model.Article
import kotlinx.coroutines.flow.first

class NewsPagingSource(
    private val category: String,
    private val webService: WebService,
    private val dataStoreRepository: DataStoreRepository,
    private val newsDao: NewsDao,
) : PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            if (page > 2) {
                LoadResult.Error(
                    Throwable(
                        "TheNewsApi is on free plan"
                    )
                )
            } else {
                val response = webService.getNews(
                    category = category,
                    page = page,
                    pageSize = 3,
                    locale = dataStoreRepository.readSelectedCountry().first() ?: "",
                    apiKey = BuildConfig.API_KEY
                )
                if (response.isSuccessful) {
                    val articles = response.body()?.articles
                    val mapSecond = newsDao.getAllNews().associateBy { it.uuid }
                    articles?.onEach { article ->
                        article.isFavourite = mapSecond.containsKey(article.uuid)
                    }
                    LoadResult.Page(
                        data = articles!!,
                        prevKey = if (page == 1) null else page.minus(1),
                        nextKey = if (response.body()!!.articles.isEmpty()) null else page.plus(
                            1
                        ),
                    )
                } else {
                    return try {
                        if (response.code() == 426) {
                            LoadResult.Page(emptyList(), prevKey = null, nextKey = null)
                        } else {
                            LoadResult.Error(
                                Throwable(
                                    "${
                                        response.errorBody()?.byteString().toString()
                                    }\n${response.code()}"
                                )
                            )
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                        LoadResult.Error(e)
                    }
                }
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}