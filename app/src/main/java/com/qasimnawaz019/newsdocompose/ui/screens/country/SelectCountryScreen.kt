package com.qasimnawaz019.newsdocompose.ui.screens.country

import android.widget.Toast
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.qasimnawaz019.newsdocompose.graphs.SelectableScreenInfo
import com.qasimnawaz019.newsdocompose.theme.NewsDoComposeTheme
import com.qasimnawaz019.newsdocompose.ui.components.SearchBar

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun SelectCountryScreen(
    navController: NavHostController,
    viewModel: CountryViewModel = hiltViewModel()
) {

    val mContext = LocalContext.current
    val query = remember { mutableStateOf("") }
    val countriesList = viewModel.countriesList

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        SearchBar(searchText = query.value,
            placeholderText = "Search Country",
            onSearchTextChanged = {
                query.value = it
                viewModel.performQuery(query.value)
            },
            onClearClick = {
                query.value = ""
                viewModel.performQuery(query.value)
            })

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
                .padding(
                    horizontal = 10.dp, vertical = 4.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            items(items = countriesList, key = { it.name }) { countryItem ->
                CountryItem(country = countryItem, onCountrySelect = {
                    viewModel.updateSelectedCountryCode(it.code)
                })
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 5.dp, bottom = 10.dp),
            onClick = {
                if (countriesList.toList().any { it.isSelected }) {
                    navController.popBackStack()
                    navController.navigate(SelectableScreenInfo.Topics.route)
                } else {
                    Toast.makeText(mContext, "Please select your country", Toast.LENGTH_SHORT)
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

@Composable
fun CountryItem(
    country: Country, onCountrySelect: (country: Country) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = { onCountrySelect(country) })
            .background(color = if (country.isSelected) NewsDoComposeTheme.colors.primary else NewsDoComposeTheme.colors.uiBackground)
            .fillMaxWidth()
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(6.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = country.icon,
            contentDescription = "flag",
            modifier = Modifier.size(30.dp),
        )
        Spacer(modifier = Modifier.width(15.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = country.name,
            fontSize = 18.sp,
            color = NewsDoComposeTheme.colors.textSecondary
        )
    }
}