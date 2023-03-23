package com.lnavmon.practica1.di

import com.lnavmon.practica1.data.settings.SettingsDataSource
import com.lnavmon.practica1.data.settings.SettingsDataSourceImpl
import com.lnavmon.practica1.data.settings.SettingsRepository
import com.lnavmon.practica1.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
    @Binds
    @Singleton
    abstract fun bindSettingsDataSource(settingsLocalDataSource: SettingsDataSourceImpl): SettingsDataSource

    @Binds
    @Singleton
    abstract fun bindSettingsRepository(settingsRepository: SettingsRepositoryImpl): SettingsRepository
}