package com.lnavmon.practica1.data.favourites

import androidx.room.*
import com.lnavmon.practica1.data.favourites.model.QuotationDto


import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotation(quotationDto: QuotationDto)

    @Delete
    suspend fun removeQuotation(quotationDto: QuotationDto)

    @Query("SELECT * FROM ${FavouritesContract.FavouriteEntry.TABLE_NAME}")
    fun getFavouriteQuotations(): Flow<List<QuotationDto>>

    @Query("SELECT * FROM ${FavouritesContract.FavouriteEntry.TABLE_NAME} WHERE ${FavouritesContract.FavouriteEntry.COLUMN_ID} = :id")
    fun getQuotationById(id: String): Flow<QuotationDto?>

    @Query("DELETE FROM ${FavouritesContract.FavouriteEntry.TABLE_NAME}")
    suspend fun deleteAllQuotations()
}
