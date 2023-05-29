package com.qasimnawaz019.newsdocompose.ui.screens.categories

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.components.bottombar.BottomBarScreenInfo


@Composable
fun ChooseTopicsScreen(
    navController: NavHostController, viewModel: CategoriesViewModel = hiltViewModel()
) {

    val mContext = LocalContext.current
    val topics = viewModel.categoriesList

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(
                    start = 20.dp, end = 20.dp, top = 30.dp, bottom = 20.dp
                ),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(topics.size) { index ->
                    val topic = topics[index]
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .border(
                                1.dp,
                                color = if (topic.isSelected) Color.Transparent else NewsDoComposeTheme.colors.primary
                            )
                            .background(
                                color = if (topic.isSelected) NewsDoComposeTheme.colors.primary else Color.Transparent,
                                shape = RoundedCornerShape(10.dp),
                            )
                            .clickable { viewModel.addToSelectedTopic(topic.name) },
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(5.dp),
                            textAlign = TextAlign.Center,
                            text = topic.name,
                            color = if (topic.isSelected) Color.White else NewsDoComposeTheme.colors.primary
                        )
                    }
                }
            }
        )

        Spacer(modifier = Modifier.weight(1.0f))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 5.dp, bottom = 10.dp),
            onClick = {
                if (topics.toList().any { it.isSelected } && topics.size < 3) {
                    navController.popBackStack()
                    navController.navigate(BottomBarScreenInfo.Home.route)
                } else {
                    Toast.makeText(
                        mContext,
                        "Please select at least 3 topics to continue",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                backgroundColor = NewsDoComposeTheme.colors.primary
            )
        ) {
            Text(text = "Next")
        }

    }
}