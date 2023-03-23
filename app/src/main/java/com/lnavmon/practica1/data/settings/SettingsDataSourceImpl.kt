package com.lnavmon.practica1.data.settings

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences) : SettingsDataSource {

    companion object SettingsConstants {
        const val USERNAME_KEY = "nombreUsuario"
        const val LANGUAGE_KEY = "idiomaCitas"
    }

    override fun getUsername(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if (USERNAME_KEY == key) {
                    trySend(getUsernamePreference())
                }
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }.flowOn(Dispatchers.IO)

    override fun getLanguage(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch {
                if (LANGUAGE_KEY == key) {
                    trySend(getLanguagePreference())
                }
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getLanguagePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }.flowOn(Dispatchers.IO)

    private fun getUsernamePreference() = sharedPreferences.getString(USERNAME_KEY, "") ?: ""

    private fun getLanguagePreference() = sharedPreferences.getString(LANGUAGE_KEY, "") ?: ""


}