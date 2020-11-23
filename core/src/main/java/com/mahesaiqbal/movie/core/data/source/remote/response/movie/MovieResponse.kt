package com.mahesaiqbal.movie.core.data.source.remote.response.movie

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    var results: List<ResultMovie>
)