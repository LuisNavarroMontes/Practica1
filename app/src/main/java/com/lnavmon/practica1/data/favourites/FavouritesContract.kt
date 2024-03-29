package com.lnavmon.practica1.data.favourites

object FavouritesContract {
    const val DATABASE_NAME = "favourites.db"

    object FavouriteEntry {
        const val TABLE_NAME = "favourites"
        const val COLUMN_ID = "id"
        const val COLUMN_TEXT = "text"
        const val COLUMN_AUTHOR = "author"
    }
}