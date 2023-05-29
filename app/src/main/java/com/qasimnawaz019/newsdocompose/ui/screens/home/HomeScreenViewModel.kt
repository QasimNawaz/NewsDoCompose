package com.qasimnawaz019.newsdocompose.ui.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    val categoriesList = mutableStateListOf<String>().apply {
        addAll(emptyList())
    }

    init {
        getCategories()
    }


    private fun getCategories() {
        viewModelScope.launch {
            repository.readSelectedCategories().collect { set ->
                categoriesList.addAll(set)
            }
        }
    }
}