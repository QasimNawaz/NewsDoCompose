package com.qasimnawaz019.data.di

import com.qasimnawaz019.data.remote.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@InstallIn(SingletonComponent::class)
@Module
abstract class NetworkModule {

    companion object {
        internal val httpLoggingInterceptor: HttpLoggingInterceptor
            @Provides
            get() {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
//                if (BuildConfig.DEBUG) {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//                } else {
//                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE
//                }
                return httpLoggingInterceptor
            }

        //WebService
        @Provides
        internal fun getApiInterface(retroFit: Retrofit): WebService {
            return retroFit.create(WebService::class.java)
        }

        @Provides
        internal fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://api.thenewsapi.com/v1/news/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

        @Provides
        internal fun getOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
            return OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build()
        }
    }

}