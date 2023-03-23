package com.lnavmon.practica1.data.settings

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(
    private val dataSource: SettingsDataSource
) : SettingsRepository {

    override fun getUsername(): Flow<String> {
        return dataSource.getUsername()
    }

    override fun getLanguage(): Flow<String> {
        return dataSource.getLanguage()
    }

}