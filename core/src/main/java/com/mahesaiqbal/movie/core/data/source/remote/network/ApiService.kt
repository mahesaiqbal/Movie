package com.mahesaiqbal.movie.core.data.source.remote.network

import com.mahesaiqbal.movie.core.data.source.remote.response.movie.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): MovieResponse
}