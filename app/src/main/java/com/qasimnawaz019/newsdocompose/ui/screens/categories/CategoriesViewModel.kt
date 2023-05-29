package com.qasimnawaz019.newsdocompose.ui.screens.categories

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    val categoriesList = mutableStateListOf<Category>().apply {
        addAll(categories)
    }

    init {
        getSelectedTopics()
    }

    private fun getSelectedTopics() {
        viewModelScope.launch {
            repository.readSelectedCategories().collect { set ->
                categories.onEach { topic ->
                    topic.isSelected = set.contains(topic.name)
                }
                categoriesList.clear()
                categoriesList.addAll(categories)
            }
        }
    }

    fun addToSelectedTopic(topic: String) {
        viewModelScope.launch {
            val set = repository.readSelectedCategories().first().toMutableSet()
            if (set.contains(topic)) {
                set.remove(topic)
            } else {
                set.add(topic)
            }
            repository.saveSelectedCategory(set)
        }
    }
}


val categories = listOf(
    Category("Science"),
    Category("Sports"),
    Category("Business"),
    Category("Health"),
    Category("Entertainment"),
    Category("Tech"),
    Category("Politics"),
    Category("Food"),
    Category("Travel"),
)