package com.qasimnawaz019.newsdocompose.ui.screens.favourite

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.usecase.NewsLocalUseCase
import com.qasimnawaz019.domain.usecase.RemoveNewsDbUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val newsLocalUseCase: NewsLocalUseCase,
    private val removeNewsDbUseCase: RemoveNewsDbUseCase,
) : ViewModel() {

    val articles = mutableStateListOf<Article>().apply {
        addAll(emptyList())
    }

    init {
        getLocalNews()
    }

    private fun getLocalNews() {
        viewModelScope.launch {
            newsLocalUseCase.execute(Unit).collect {
                articles.addAll(it)
            }
        }
    }

    fun removeNewsFromDb(article: Article) {
        viewModelScope.launch {
            articles.remove(article)
            removeNewsDbUseCase.execute(RemoveNewsDbUseCase.Params(article = article))
        }
    }
}