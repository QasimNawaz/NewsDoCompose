package com.qasimnawaz019.data.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

val Context.onBoardingDataStore: DataStore<Preferences> by preferencesDataStore(name = "on_boarding_pref")
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "news_do_compose_pref")

class DataStoreRepository(context: Context) {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "on_boarding_completed")
        val countryKey = stringPreferencesKey(name = "news_do_compose_country")
        val categoriesKey = stringSetPreferencesKey(name = "news_do_compose_categories")
    }

    private val onBoardingDataStore = context.onBoardingDataStore
    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(completed: Boolean) {
        onBoardingDataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = completed
        }
    }

    suspend fun saveSelectedCountry(country: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.countryKey] = country
        }
    }

    suspend fun saveSelectedCategory(categories: Set<String>) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.categoriesKey] = categories
        }
    }

    fun readSelectedCountry(): Flow<String?> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val onBoardingState = preferences[PreferencesKey.countryKey]
            onBoardingState
        }
    }

    fun readSelectedCategories(): Flow<Set<String>> {
        return dataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val onBoardingState = preferences[PreferencesKey.categoriesKey] ?: emptySet()
            onBoardingState
        }
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return onBoardingDataStore.data.catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }.map { preferences ->
            val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
            onBoardingState
        }
    }
}