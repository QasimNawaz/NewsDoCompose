package com.qasimnawaz019.data.repository.dataSourceImpl

import com.qasimnawaz019.data.di.IoDispatcher
import com.qasimnawaz019.data.repository.RemoteData
import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.NewsApiResponse
import com.qasimnawaz019.domain.repository.SearchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteData: RemoteData,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : SearchRepository {

    override suspend fun searchNews(
        query: String,
    ): Flow<ApiResponse<NewsApiResponse?>> {
        return flow {
            emit(remoteData.searchNews(query = query))
        }.flowOn(dispatcher)
    }
}