package com.mahesaiqbal.movie.core.utils

import com.mahesaiqbal.movie.core.data.source.local.entity.PopularMovieEntity
import com.mahesaiqbal.movie.core.data.source.remote.response.movie.ResultMovie
import com.mahesaiqbal.movie.core.domain.model.Movie

object DataMapper {

    fun mapResponsesToEntities(input: List<ResultMovie>): List<PopularMovieEntity> {
        val movieList = ArrayList<PopularMovieEntity>()
        input.map {
            val movie = PopularMovieEntity(
                id = it.id,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<PopularMovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                backdropPath = it.backdropPath,
                originalLanguage = it.originalLanguage,
                overview = it.overview,
                popularity = it.popularity,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                voteAverage = it.voteAverage,
                voteCount = it.voteCount,
                isFavorite = it.isFavorite
            )
        }

//    fun mapEntityToDomain(input: PopularMovieEntity): Movie =
//        Movie(
//            id = input.id,
//            backdropPath = input.backdropPath,
//            originalLanguage = input.originalLanguage,
//            overview = input.overview,
//            popularity = input.popularity,
//            posterPath = input.posterPath,
//            releaseDate = input.releaseDate,
//            title = input.title,
//            voteAverage = input.voteAverage,
//            voteCount = input.voteCount,
//            isFavorite = input.isFavorite
//        )

    fun mapDomainToEntity(input: Movie) = PopularMovieEntity(
        id = input.id,
        backdropPath = input.backdropPath,
        originalLanguage = input.originalLanguage,
        overview = input.overview,
        popularity = input.popularity,
        posterPath = input.posterPath,
        releaseDate = input.releaseDate,
        title = input.title,
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
        isFavorite = input.isFavorite
    )
}