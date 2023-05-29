package com.qasimnawaz019.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.qasimnawaz019.domain.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao
}