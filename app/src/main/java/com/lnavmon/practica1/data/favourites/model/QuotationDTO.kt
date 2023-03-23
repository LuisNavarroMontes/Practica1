package com.lnavmon.practica1.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lnavmon.practica1.data.favourites.FavouritesContract

@Entity(tableName = FavouritesContract.FavouriteEntry.TABLE_NAME)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_ID)
    val identificador: String,
    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_TEXT)
    val nombre: String,
    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_AUTHOR)
    val autor: String
)
