package com.qasimnawaz019.data.remote

import com.qasimnawaz019.domain.model.NewsApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("all")
    suspend fun getNews(
        @Query("categories") category: String,
        @Query("page") page: Int,
        @Query("limit") pageSize: Int,
        @Query("locale") locale: String,
        @Query("api_token") apiKey: String,
    ): Response<NewsApiResponse?>

    @GET("all")
    suspend fun searchNews(
        @Query("search") search: String,
        @Query("limit") pageSize: Int,
        @Query("locale") locale: String,
        @Query("api_token") apiKey: String,
    ): Response<NewsApiResponse?>

}