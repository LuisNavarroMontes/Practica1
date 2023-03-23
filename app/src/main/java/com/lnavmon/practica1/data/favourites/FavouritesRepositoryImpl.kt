package com.lnavmon.practica1.data.favourites

import com.lnavmon.practica1.data.favourites.model.QuotationDto
import com.lnavmon.practica1.data.favourites.model.toDomain
import com.lnavmon.practica1.data.favourites.model.toDto
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val dataSource: FavouritesDataSource
) : FavouritesRepository {
    override suspend fun addFavourite(quotation: Quotation) {
        dataSource.addFavourite(quotation.toDto())
    }

    override suspend fun deleteFavourite(quotation: Quotation) {
        dataSource.deleteFavourite(quotation.toDto())
    }

    override fun getAllFavourites(): Flow<List<Quotation>> {
        return dataSource.getAllFavourites().map {list:List<QuotationDto> -> list.map { item: QuotationDto -> item.toDomain() } }
    }

    override fun getFavouriteById(id: Long): Flow<Quotation?> {
        return dataSource.getFavouriteById(id).map { quotationDto:QuotationDto? -> quotationDto?.toDomain() }
    }

    override suspend fun deleteAllFavourites() {
        dataSource.deleteAllFavourites()
    }
}