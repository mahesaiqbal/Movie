package com.mahesaiqbal.movie.core.domain.repository

import com.mahesaiqbal.movie.core.data.Resource
import com.mahesaiqbal.movie.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun getPopularMovies(): Flow<Resource<List<Movie>>>

    fun getFavoritePopularMovies(): Flow<List<Movie>>

    fun setFavoritePopularMovie(movie: Movie, state: Boolean)
}