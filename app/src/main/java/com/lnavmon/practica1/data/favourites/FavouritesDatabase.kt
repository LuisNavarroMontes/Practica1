package com.lnavmon.practica1.data.favourites

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lnavmon.practica1.data.favourites.model.QuotationDto

@Database(entities = [QuotationDto::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {
    abstract fun favouritesDao(): FavouritesDao

    /*companion object {
        @Volatile
        private var INSTANCE: FavouritesDatabase? = null

        fun getInstance(context: Context): FavouritesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouritesDatabase::class.java,
                    FavouritesContract.DATABASE_NAME
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }*/
}