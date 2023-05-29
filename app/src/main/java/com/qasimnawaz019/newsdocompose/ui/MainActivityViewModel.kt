package com.qasimnawaz019.newsdocompose.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.newsdocompose.graphs.AuthScreenInfo
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.OnBoardingScreen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    private val _startDestination: MutableState<String> =
        mutableStateOf(OnBoardingScreen.Welcome.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            // To get value ones
            if (repository.readOnBoardingState().first()) {
                _startDestination.value = AuthScreenInfo.Login.route
            } else {
                _startDestination.value = OnBoardingScreen.Welcome.route
            }
            // To get value every time datastore updated
//            repository.readOnBoardingState().collect { completed ->
//                if (completed) {
//                    _startDestination.value = AuthScreenInfo.Login.route
//                } else {
//                    _startDestination.value = OnBoardingScreen.Welcome.route
//                }
//            }
        }
    }
}