package com.lnavmon.practica1.data.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getUsername(): Flow<String>
    fun getLanguage(): Flow<String>
}