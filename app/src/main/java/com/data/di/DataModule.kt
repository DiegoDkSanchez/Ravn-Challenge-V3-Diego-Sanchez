package com.data.di

import android.content.Context
import androidx.room.Room
import com.apollographql.apollo.ApolloClient
import com.data.dao.FavoritesDao
import com.data.database.AppDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.builder()
            .serverUrl("https://swapi-graphql.netlify.app/.netlify/functions/index")
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDataBase {
        return Room.databaseBuilder(
            appContext,
            AppDataBase::class.java,
            "RavnChallenge"
        ).build()
    }

    @Provides
    fun provideFavoriteDao(appDataBase: AppDataBase): FavoritesDao {
        return appDataBase.favoritesDao()
    }

}