package com.qasimnawaz019.domain.usecase

import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.repository.NewsLocalRepository
import com.qasimnawaz019.domain.usecase.base.SuspendUseCase
import javax.inject.Inject

class RemoveNewsDbUseCase @Inject constructor(
    private val newsLocalRepository: NewsLocalRepository,
) : SuspendUseCase<RemoveNewsDbUseCase.Params, Unit> {

    data class Params(val article: Article)

    override suspend fun execute(params: Params) =
        newsLocalRepository.removeNewsFromDB(params.article)

}