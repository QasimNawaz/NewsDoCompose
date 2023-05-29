package com.qasimnawaz019.newsdocompose.ui.screens.home.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.usecase.AddNewsDbUseCase
import com.qasimnawaz019.domain.usecase.NewsUseCase
import com.qasimnawaz019.domain.usecase.RemoveNewsDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase,
    private val addNewsDbUseCase: AddNewsDbUseCase,
    private val removeNewsDbUseCase: RemoveNewsDbUseCase,
) : ViewModel() {

    fun getNews(category: String): Flow<PagingData<Article>> =
        newsUseCase.execute(
            NewsUseCase.Params(
                category
            )
        ).cachedIn(viewModelScope)

    fun addToBookmark(article: Article) {
        viewModelScope.launch {
            article.isFavourite = true
            addNewsDbUseCase.execute(AddNewsDbUseCase.Params(article = article))
        }
    }

    fun removeNewsFromDb(article: Article) {
        viewModelScope.launch {
//            article.isFavourite = false
            removeNewsDbUseCase.execute(RemoveNewsDbUseCase.Params(article = article))
        }
    }
}