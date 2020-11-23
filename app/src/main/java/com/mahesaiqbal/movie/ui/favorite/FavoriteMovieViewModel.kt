package com.mahesaiqbal.movie.ui.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase

class FavoriteMovieViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoritePopularMovies = movieUseCase.getFavoritePopularMovies().asLiveData()
}