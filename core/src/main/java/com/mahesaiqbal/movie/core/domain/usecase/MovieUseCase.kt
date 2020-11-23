package com.mahesaiqbal.movie.core.domain.usecase

import com.mahesaiqbal.movie.core.data.Resource
import com.mahesaiqbal.movie.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>

    fun getFavoritePopularMovies(): Flow<List<Movie>>

    fun setFavoritePopularMovie(movie: Movie, state: Boolean)
}