package com.qasimnawaz019.domain.usecase

import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.NewsApiResponse
import com.qasimnawaz019.domain.repository.SearchRepository
import com.qasimnawaz019.domain.usecase.base.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchRepository,
) : SuspendUseCase<SearchUseCase.Params, @JvmSuppressWildcards Flow<ApiResponse<NewsApiResponse?>>> {

    data class Params(val query: String)

    override suspend fun execute(params: Params) =
        searchRepository.searchNews(query = params.query)

}