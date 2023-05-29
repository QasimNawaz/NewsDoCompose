package com.qasimnawaz019.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.qasimnawaz019.data.BuildConfig
import com.qasimnawaz019.data.db.NewsDao
import com.qasimnawaz019.data.remote.WebService
import com.qasimnawaz019.data.repository.dataSource.NewsPagingSource
import com.qasimnawaz019.data.repository.dataSource.RemoteDataSource
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.model.NewsApiResponse
import com.qasimnawaz019.domain.utils.ConnectivityException
import com.qasimnawaz019.domain.utils.NetworkConnectivity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val webService: WebService,
    private val dataStoreRepository: DataStoreRepository,
    private val networkConnectivity: NetworkConnectivity,
    private val newsDao: NewsDao,
) : RemoteDataSource {

    override suspend fun searchNews(query: String): ApiResponse<NewsApiResponse?> {
        return processCall {
            webService.searchNews(
                search = query,
                pageSize = 3,
                locale = dataStoreRepository.readSelectedCountry().first() ?: "",
                apiKey = BuildConfig.API_KEY
            )
        }
    }

    private inline fun <reified T> processCall(function: () -> Response<T?>): ApiResponse<T?> {
        if (!networkConnectivity.isConnected()) {
            return ApiResponse.Error(ConnectivityException())
        }
        return try {
            val response = function.invoke()
            if (response.isSuccessful) {
                ApiResponse.Success(
                    response.body()
                )
            } else {
                return try {
                    ApiResponse.Error(
                        Exception(
                            "${
                                response.errorBody()?.byteString().toString()
                            }\n${response.code()}"
                        )
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    ApiResponse.Error(e)
                }

            }
        } catch (e: IOException) {
            ApiResponse.Error(e)
        }
    }

    override suspend fun getNews(category: String): Flow<PagingData<Article>> {
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