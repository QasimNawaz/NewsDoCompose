package com.qasimnawaz019.newsdocompose.ui.screens.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.domain.model.ApiResponse
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.domain.model.NewsApiResponse
import com.qasimnawaz019.domain.usecase.AddNewsDbUseCase
import com.qasimnawaz019.domain.usecase.RemoveNewsDbUseCase
import com.qasimnawaz019.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    private val addNewsDbUseCase: AddNewsDbUseCase,
    private val removeNewsDbUseCase: RemoveNewsDbUseCase,
) : ViewModel() {

    private val searchText: MutableStateFlow<String> = MutableStateFlow("")
    private var showProgressBar: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private var newsData: MutableStateFlow<ApiResponse<NewsApiResponse?>> =
        MutableStateFlow(ApiResponse.Empty)

    val newsSearchModelState = combine(
        searchText, newsData, showProgressBar
    ) { text, data, showProgress ->

        NewsSearchModelState(
            text, data, showProgress
        )
    }

    init {
        viewModelScope.launch {
            @OptIn(FlowPreview::class) searchText.debounce(1000).collect(::searchNews)
        }
    }


    fun onSearchTextChanged(query: String) {
        searchText.value = query
    }

    private fun searchNews(query: String) {
        if (query.isEmpty()) {
            newsData.value = ApiResponse.Empty
            return
        }
        viewModelScope.launch {
            searchUseCase.execute(SearchUseCase.Params(query)).collect {
                newsData.value = it
            }
        }
    }

    fun onClearClick() {
        searchText.value = ""
        newsData.value = ApiResponse.Empty
    }

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