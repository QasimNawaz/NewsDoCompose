package com.qasimnawaz019.domain.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Parcelize
data class NewsApiResponse(

    @field:SerializedName("data")
    val articles: List<Article> = emptyList(),

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("warnings")
    val warnings: List<String>? = null
) : Parcelable

@Entity(tableName = "newsTable")
@Parcelize
data class Article(

    @field:SerializedName("snippet")
    val snippet: String? = null,

    @field:SerializedName("keywords")
    val keywords: String? = null,

    @field:SerializedName("image_url")
    val imageUrl: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("language")
    val language: String? = null,

    @field:SerializedName("source")
    val source: String? = null,

//    @field:SerializedName("categories")
//    val categories: List<String>? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("published_at")
    val publishedAt: String? = null,

    @PrimaryKey
    @field:SerializedName("uuid")
    val uuid: String = "010",

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("relevance_score")
    val relevanceScore: Double? = null,

    @field:SerializedName("isFavourite")
    var isFavourite: Boolean = false

) : Parcelable

@Parcelize
data class Meta(

    @field:SerializedName("found")
    val found: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null,

    @field:SerializedName("page")
    val page: Int? = null,

    @field:SerializedName("returned")
    val returned: Int? = null
) : Parcelable
