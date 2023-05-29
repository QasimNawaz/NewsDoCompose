package com.qasimnawaz019.newsdocompose.ui.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.newsdocompose.graphs.SelectableScreenInfo
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.BottomBarScreenInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading

    private val _startDestination: MutableState<String> =
        mutableStateOf(BottomBarScreenInfo.Home.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            val selectedCountry = repository.readSelectedCountry().first()
            val selectedTopics = repository.readSelectedCategories().first()
            if (selectedCountry == null) {
                _startDestination.value = SelectableScreenInfo.Country.route
            } else if (selectedTopics.isEmpty()) {
                _startDestination.value = SelectableScreenInfo.Topics.route
            } else {
                _startDestination.value = BottomBarScreenInfo.Home.route
            }
            _isLoading.value = false
        }
    }

}