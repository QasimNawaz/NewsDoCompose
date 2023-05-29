package com.qasimnawaz019.domain.usecase

import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.repository.NewsLocalRepository
import com.qasimnawaz019.domain.usecase.base.SuspendUseCase
import com.qasimnawaz019.domain.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsLocalUseCase @Inject constructor(
    private val newsLocalRepository: NewsLocalRepository,
) : SuspendUseCase<Unit, @JvmSuppressWildcards Flow<List<Article>>> {

    override suspend fun execute(params: Unit): Flow<List<Article>> =
        newsLocalRepository.getNewsFromDB()

}