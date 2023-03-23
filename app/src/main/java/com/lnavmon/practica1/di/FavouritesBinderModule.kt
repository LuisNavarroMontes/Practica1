package com.lnavmon.practica1.di

import com.lnavmon.practica1.data.favourites.FavouritesDataSource
import com.lnavmon.practica1.data.favourites.FavouritesDataSourceImpl
import com.lnavmon.practica1.data.favourites.FavouritesRepository
import com.lnavmon.practica1.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {

    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource

    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
}