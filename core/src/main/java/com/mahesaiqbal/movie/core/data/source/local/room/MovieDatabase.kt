package com.mahesaiqbal.movie.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mahesaiqbal.movie.core.data.source.local.entity.PopularMovieEntity

@Database(entities = [
    PopularMovieEntity::class
], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}