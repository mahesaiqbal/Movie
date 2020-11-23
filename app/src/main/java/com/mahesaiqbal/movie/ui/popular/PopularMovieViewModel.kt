package com.mahesaiqbal.movie.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase

class PopularMovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val popularMovies = movieUseCase.getPopularMovies().asLiveData()
}