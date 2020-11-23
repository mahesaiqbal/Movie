package com.mahesaiqbal.movie.core.domain.usecase

import com.mahesaiqbal.movie.core.data.Resource
import com.mahesaiqbal.movie.core.domain.model.Movie
import com.mahesaiqbal.movie.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) : MovieUseCase {
    override fun getPopularMovies(): Flow<Resource<List<Movie>>> = movieRepository.getPopularMovies()

    override fun getFavoritePopularMovies(): Flow<List<Movie>> = movieRepository.getFavoritePopularMovies()

    override fun setFavoritePopularMovie(movie: Movie, state: Boolean) = movieRepository.setFavoritePopularMovie(movie, state)
}