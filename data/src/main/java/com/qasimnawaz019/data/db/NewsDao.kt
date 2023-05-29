package com.qasimnawaz019.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.qasimnawaz019.domain.model.Article


@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNews(article: Article)

    @Query("SELECT * FROM newsTable")
    suspend fun getAllNews(): List<Article>

    @Query("SELECT * FROM newsTable WHERE uuid = :uuid")
    suspend fun getNewsById(uuid: String): Article

    @Query("DELETE FROM newsTable WHERE uuid = :uuid")
    suspend fun deleteNewsById(uuid: String)

    @Query("DELETE FROM newsTable")
    suspend fun deleteAllNews()

    @Delete
    suspend fun deleteNewsFromDB(article: Article)

}