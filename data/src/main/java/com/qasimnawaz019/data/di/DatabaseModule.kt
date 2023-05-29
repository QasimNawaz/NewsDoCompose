package com.qasimnawaz019.data.di

import android.content.Context
import androidx.room.Room
import com.qasimnawaz019.data.db.AppDatabase
import com.qasimnawaz019.data.db.NewsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(appContext, AppDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideMovieDao(newsDB: AppDatabase): NewsDao = newsDB.newsDao()
}