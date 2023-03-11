package com.data.dao

import androidx.room.*
import com.data.entities.FavoritesEntity

@Dao
interface FavoritesDao {
    @Query("SELECT * FROM FavoritesEntity")
    fun getFavorites(): List<FavoritesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(personEntity: FavoritesEntity)

    @Delete
    fun deleteFavorite(personEntity: FavoritesEntity)
}