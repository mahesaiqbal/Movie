package com.mahesaiqbal.movie.core.data.source.local

import com.mahesaiqbal.movie.core.data.source.local.entity.PopularMovieEntity
import com.mahesaiqbal.movie.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getPopularMovies(): Flow<List<PopularMovieEntity>> = movieDao.getPopularMovies()

    fun getFavoritePopularMovies(): Flow<List<PopularMovieEntity>> = movieDao.getFavoritePopularMovies()

    suspend fun insertPopularMovies(movieList: List<PopularMovieEntity>) = movieDao.insertPopularMovies(movieList)

    fun setFavoritePopularMovie(movie: PopularMovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDao.updatePopularMovie(movie)
    }
}