package com.lnavmon.practica1.data.favourites

import com.lnavmon.practica1.data.favourites.model.QuotationDto
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addFavourite(quotation: QuotationDto)
    suspend fun deleteFavourite(quotation: QuotationDto)
    fun getAllFavourites(): Flow<List<QuotationDto>>
    fun getFavouriteById(id: Long): Flow<QuotationDto?>
    suspend fun deleteAllFavourites()

}