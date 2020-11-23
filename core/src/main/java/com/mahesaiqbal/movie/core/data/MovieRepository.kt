package com.mahesaiqbal.movie.core.data

import com.mahesaiqbal.movie.core.data.source.local.LocalDataSource
import com.mahesaiqbal.movie.core.data.source.remote.RemoteDataSource
import com.mahesaiqbal.movie.core.data.source.remote.network.ApiResponse
import com.mahesaiqbal.movie.core.data.source.remote.response.movie.ResultMovie
import com.mahesaiqbal.movie.core.domain.model.Movie
import com.mahesaiqbal.movie.core.domain.repository.IMovieRepository
import com.mahesaiqbal.movie.core.utils.AppExecutors
import com.mahesaiqbal.movie.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getPopularMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<ResultMovie>>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getPopularMovies().map { DataMapper.mapEntitiesToDomain(it) }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<ResultMovie>>> =
                remoteDataSource.getPopularMovies()

            override suspend fun saveCallResult(data: List<ResultMovie>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertPopularMovies(movieList)
            }
        }.asFlow()

    override fun getFavoritePopularMovies(): Flow<List<Movie>> =
        localDataSource.getFavoritePopularMovies().map { DataMapper.mapEntitiesToDomain(it) }

    override fun setFavoritePopularMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoritePopularMovie(movieEntity, state) }
    }
}