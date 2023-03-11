package com.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.data.entities.FavoritesEntity

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM FavoritesEntity")
    fun getFavorites(): List<FavoritesEntity>

    @Insert
    fun insertFavorite(personEntity: FavoritesEntity)

    @Delete
    fun deleteFavorite(personEntity: FavoritesEntity)
}