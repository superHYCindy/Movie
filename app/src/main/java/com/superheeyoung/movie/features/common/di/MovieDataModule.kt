package com.superheeyoung.movie.features.common.di

import com.superheeyoung.movie.features.common.repository.MovieDataSource
import com.superheeyoung.movie.features.common.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDataModule {
    @Singleton
    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepository) : MovieDataSource
}