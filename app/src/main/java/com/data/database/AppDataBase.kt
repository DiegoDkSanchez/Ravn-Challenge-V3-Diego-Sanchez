package com.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.dao.FavoritesDao
import com.data.entities.FavoritesEntity

@Database(entities = [FavoritesEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
}