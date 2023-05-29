package com.qasimnawaz019.domain.usecase

import androidx.paging.PagingData
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.repository.NewsRemoteRepository
import com.qasimnawaz019.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCase @Inject constructor(
    private val newsRepository: NewsRemoteRepository,
) : UseCase<NewsUseCase.Params, @JvmSuppressWildcards Flow<PagingData<Article>>> {

    data class Params(val category: String)

    override fun execute(params: Params) = newsRepository.getNews(category = params.category)

}