package com.qasimnawaz019.newsdocompose.ui.screens.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.qasimnawaz019.domain.model.Article
import com.qasimnawaz019.newsdocompose.utils.rememberFlowWithLifecycle

@Composable
fun DetailsScreen(uuid: String, viewModel: DetailsViewModel = hiltViewModel()) {

//    val viewState by rememberFlowWithLifecycle(viewModel.article).collectAsState(
//        initial = Article.Empty
//    )

    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Text(text = "UUID: $uuid")
    }
}