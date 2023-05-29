package com.qasimnawaz019.newsdocompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.qasimnawaz019.newsdocompose.graphs.RootNavigationGraph
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //    @Inject
//    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        setContent {
            NewsDoComposeTheme {
                val screen by viewModel.startDestination
                RootNavigationGraph(
                    navController = rememberNavController(),
                    startDestination = screen
                )
            }
        }
    }
}