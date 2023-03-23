package com.lnavmon.practica1.data.favourites

import com.lnavmon.practica1.data.favourites.model.QuotationDto
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun addFavourite(quotation: Quotation)
    suspend fun deleteFavourite(quotation: Quotation)
    fun getAllFavourites(): Flow<List<Quotation>>
    fun getFavouriteById(id: Long): Flow<Quotation?>
    suspend fun deleteAllFavourites()
}