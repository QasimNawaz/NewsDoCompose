package com.qasimnawaz019.newsdocompose.ui.screens.country

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.qasimnawaz019.data.repository.datastore.DataStoreRepository
import com.qasimnawaz019.newsdocompose.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    val countriesList = mutableStateListOf<Country>().apply {
        addAll(countries)
    }

    init {
        getAllCountries()
    }

    private fun getAllCountries() {
        viewModelScope.launch {
            repository.readSelectedCountry().collect { countryCode ->
                countries.onEach { it.isSelected = it.code == countryCode }
                countriesList.clear()
                countriesList.addAll(countries)
            }
        }
    }

    fun performQuery(
        query: String,
    ) {
        viewModelScope.launch {
            countriesList.clear()
            if (query.isNotEmpty()) {
                countriesList.addAll(countries.filter {
                    it.name.contains(
                        query,
                        ignoreCase = true
                    )
                })
            } else {
                countriesList.addAll(countries)
            }
        }
    }

    fun updateSelectedCountryCode(code: String) {
        viewModelScope.launch {
            repository.saveSelectedCountry(code)
        }
    }
}

val countries = listOf(
    Country(name = "Argentina", code = "ar", icon = R.drawable.ar),
    Country(name = "Armenia", code = "am", icon = R.drawable.am),
    Country(name = "Australia", code = "au", icon = R.drawable.au),
    Country(name = "Austria", code = "at", icon = R.drawable.at),
    Country(name = "Belarus", code = "by", icon = R.drawable.by),
    Country(name = "Belgium", code = "be", icon = R.drawable.be),
    Country(name = "Bolivia", code = "bo", icon = R.drawable.bo),
    Country(name = "Brazil", code = "br", icon = R.drawable.br),
    Country(name = "Bulgaria", code = "bg", icon = R.drawable.bg),
    Country(name = "Canada", code = "ca", icon = R.drawable.ca),
    Country(name = "Chile", code = "cl", icon = R.drawable.cl),
    Country(name = "China", code = "cn", icon = R.drawable.cn),
    Country(name = "Colombia", code = "co", icon = R.drawable.co),
    Country(name = "Croatia", code = "hr", icon = R.drawable.hr),
    Country(name = "Czechia", code = "cz", icon = R.drawable.cz),
    Country(name = "Ecuador", code = "ec", icon = R.drawable.ec),
    Country(name = "Egypt", code = "eg", icon = R.drawable.eg),
    Country(name = "France", code = "fr", icon = R.drawable.fr),
    Country(name = "Germany", code = "de", icon = R.drawable.de),
    Country(name = "Greece", code = "gr", icon = R.drawable.gr),
    Country(name = "Honduras", code = "hn", icon = R.drawable.hn),
    Country(name = "Hong Kong", code = "hk", icon = R.drawable.hk),
    Country(name = "India", code = "in", icon = R.drawable.`in`),
    Country(name = "Indonesia", code = "id", icon = R.drawable.id),
    Country(name = "Iran", code = "ir", icon = R.drawable.ir),
    Country(name = "Ireland", code = "ie", icon = R.drawable.ie),
    Country(name = "Italy", code = "it", icon = R.drawable.it),
    Country(name = "Japan", code = "jp", icon = R.drawable.jp),
    Country(name = "Korea", code = "kr", icon = R.drawable.kr),
    Country(name = "Mexico", code = "mx", icon = R.drawable.mx),
    Country(name = "Netherlands", code = "nl", icon = R.drawable.nl),
    Country(name = "New Zealand", code = "nz", icon = R.drawable.nz),
    Country(name = "Nicaragua", code = "ni", icon = R.drawable.ni),
    Country(name = "Pakistan", code = "pk", icon = R.drawable.pk),
    Country(name = "Panama", code = "pa", icon = R.drawable.pa),
    Country(name = "Peru", code = "pe", icon = R.drawable.pe),
    Country(name = "Poland", code = "pl", icon = R.drawable.pl),
    Country(name = "Portugal", code = "pt", icon = R.drawable.pt),
    Country(name = "Qatar", code = "qa", icon = R.drawable.qa),
    Country(name = "Romania", code = "ro", icon = R.drawable.ro),
    Country(name = "Russia", code = "ru", icon = R.drawable.ru),
    Country(name = "Saudi Arabia", code = "sa", icon = R.drawable.sa),
    Country(name = "South Africa", code = "za", icon = R.drawable.za),
    Country(name = "Spain", code = "es", icon = R.drawable.es),
    Country(name = "Switzerland", code = "ch", icon = R.drawable.ch),
    Country(name = "Syria", code = "sy", icon = R.drawable.sy),
    Country(name = "Taiwan", code = "tw", icon = R.drawable.tw),
    Country(name = "Thailand", code = "th", icon = R.drawable.th),
    Country(name = "Turkey", code = "tr", icon = R.drawable.tr),
    Country(name = "Ukraine", code = "ua", icon = R.drawable.ua),
    Country(name = "United Kingdom", code = "gb", icon = R.drawable.gb_eng),
    Country(name = "United States Of America", code = "us", icon = R.drawable.us),
    Country(name = "Uruguay", code = "uy", icon = R.drawable.uy),
    Country(name = "Venezuela", code = "ve", icon = R.drawable.ve),
)