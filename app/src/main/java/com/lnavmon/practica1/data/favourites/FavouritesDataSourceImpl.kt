package com.lnavmon.practica1.data.favourites
import com.lnavmon.practica1.data.favourites.model.QuotationDto
import com.lnavmon.practica1.iu.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(private val favouritesDao: FavouritesDao) : FavouritesDataSource {

    override suspend fun addFavourite(quotation: QuotationDto) {
        favouritesDao.addQuotation(quotation)
    }

    override suspend fun deleteFavourite(quotation: QuotationDto) {
        favouritesDao.removeQuotation(quotation)
    }

    override fun getAllFavourites(): Flow<List<QuotationDto>> {
        return favouritesDao.getFavouriteQuotations()
    }

    override fun getFavouriteById(id: Long): Flow<QuotationDto?> {
        return favouritesDao.getQuotationById(id.toString())
    }

    override suspend fun deleteAllFavourites() {
        favouritesDao.deleteAllQuotations()
    }
}