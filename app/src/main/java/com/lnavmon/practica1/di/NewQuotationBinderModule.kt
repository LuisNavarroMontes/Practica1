package com.lnavmon.practica1.di

import com.lnavmon.practica1.data.newquotation.NewQuotationRepository
import com.lnavmon.practica1.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(newQuotationRepositoryImpl: NewQuotationRepositoryImpl): NewQuotationRepository
}