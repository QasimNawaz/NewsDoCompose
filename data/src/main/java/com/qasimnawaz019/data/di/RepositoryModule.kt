package com.qasimnawaz019.data.di

import com.qasimnawaz019.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import com.qasimnawaz019.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import com.qasimnawaz019.data.repository.dataSourceImpl.SearchRepositoryImpl
import com.qasimnawaz019.domain.repository.NewsLocalRepository
import com.qasimnawaz019.domain.repository.NewsRemoteRepository
import com.qasimnawaz019.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindNewsRepository(
        newsRepositoryImpl: NewsRemoteDataSourceImpl
    ): NewsRemoteRepository

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    abstract fun bindNewsLocalRepository(
        newsLocalDataSourceImpl: NewsLocalDataSourceImpl
    ): NewsLocalRepository

}