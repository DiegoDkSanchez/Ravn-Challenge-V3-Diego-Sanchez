package com.ravn_challenge.di

import com.apollographql.apollo.ApolloClient
import com.data.dao.FavoritesDao
import com.domain.repository.StarWarsRepository
import com.data.repositoryimpl.StarWarsRepositoryImpl
import com.domain.usecases.GetAllPeopleUseCase
import com.domain.utils.DomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRepository(apolloClient: ApolloClient, favoritesDao: FavoritesDao): StarWarsRepository {
        return StarWarsRepositoryImpl(apolloClient, favoritesDao)
    }

    @Provides
    fun provideDomainMapper(): DomainMapper {
        return DomainMapper()
    }

    @Provides
    fun provideGetAllPeopleUseCase(
        starWarsRepository: StarWarsRepository,
        domainMapper: DomainMapper,
    ): GetAllPeopleUseCase {
        return GetAllPeopleUseCase(starWarsRepository, domainMapper)
    }
}