package com.example.animeapp.AnimeData.di

import com.example.animeapp.AnimeData.data.repository.AnimeRepositoryImp
import com.example.animeapp.AnimeData.domain.repository.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAnimeListRepository(
        animeRepositoryImp: AnimeRepositoryImp
    ):AnimeRepository


}