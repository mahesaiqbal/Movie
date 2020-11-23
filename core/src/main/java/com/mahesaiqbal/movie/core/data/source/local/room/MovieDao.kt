package com.mahesaiqbal.movie.core.data.source.local.room

import androidx.room.*
import com.mahesaiqbal.movie.core.data.source.local.entity.PopularMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM popular_movie")
    fun getPopularMovies(): Flow<List<PopularMovieEntity>>

    @Query("SELECT * FROM popular_movie WHERE isFavorite = 1")
    fun getFavoritePopularMovies(): Flow<List<PopularMovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovies(movie: List<PopularMovieEntity>)

    @Update
    fun updatePopularMovie(movie: PopularMovieEntity)
}