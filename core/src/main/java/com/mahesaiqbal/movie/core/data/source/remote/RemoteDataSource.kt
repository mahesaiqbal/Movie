package com.mahesaiqbal.movie.core.data.source.remote

import com.mahesaiqbal.movie.core.BuildConfig
import com.mahesaiqbal.movie.core.data.source.remote.network.ApiResponse
import com.mahesaiqbal.movie.core.data.source.remote.network.ApiService
import com.mahesaiqbal.movie.core.data.source.remote.response.movie.ResultMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {

    suspend fun getPopularMovies(): Flow<ApiResponse<List<ResultMovie>>> {
        return flow {
            try {
                val response = apiService.getPopularMovies(BuildConfig.API_KEY)
                val data = response.results

                if (data.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}