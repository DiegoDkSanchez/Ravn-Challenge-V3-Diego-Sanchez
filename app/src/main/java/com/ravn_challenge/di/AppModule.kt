package com.ravn_challenge.di

import com.apollographql.apollo.ApolloClient
import com.data.dao.FavoritesDao
import com.data.repositoryimpl.StarWarsRepositoryImpl
import com.data.utils.DomainMapper
import com.domain.repository.StarWarsRepository
import com.domain.usecases.GetAllPeopleUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRepository(
        apolloClient: ApolloClient,
        favoritesDao: FavoritesDao,
        domainMapper: DomainMapper
    ): StarWarsRepository {
        return StarWarsRepositoryImpl(apolloClient, favoritesDao, domainMapper)
    }

    @Provides
    fun provideDomainMapper(): DomainMapper {
        return DomainMapper()
    }

    @Provides
    fun provideGetAllPeopleUseCase(
        starWarsRepository: StarWarsRepository
    ): GetAllPeopleUseCase {
        return GetAllPeopleUseCase(starWarsRepository)
    }
}