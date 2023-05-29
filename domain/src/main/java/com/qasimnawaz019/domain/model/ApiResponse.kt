package com.qasimnawaz019.domain.model

sealed class ApiResponse<out T : Any?> {
    object Loading : ApiResponse<Nothing>()
    class Success<out T : Any?>(val value: T?) : ApiResponse<T?>()
    class Error(val cause: Exception? = null) : ApiResponse<Nothing>()
    object Empty : ApiResponse<Nothing>()
}

val <T> T.exhaustive: T
    get() = this