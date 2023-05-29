package com.qasimnawaz019.newsdocompose.graphs.args

import com.google.gson.Gson
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.utils.JsonNavType

class ArticleArgType : JsonNavType<Article>() {

    override fun fromJsonParse(value: String): Article = Gson().fromJson(value, Article::class.java)

    override fun Article.getJsonParse(): String = Gson().toJson(this)
}