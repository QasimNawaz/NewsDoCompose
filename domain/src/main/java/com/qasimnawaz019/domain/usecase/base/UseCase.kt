package com.qasimnawaz019.domain.usecase.base

interface UseCase<in Params, out T> {
    fun execute(params: Params): T
}