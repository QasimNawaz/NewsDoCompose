package com.qasimnawaz019.domain.usecase.base

interface SuspendUseCase<in Params, out T> {
    suspend fun execute(params: Params) : T
}