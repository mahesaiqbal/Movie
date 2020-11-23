package com.mahesaiqbal.movie.favorite.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase

class FavoriteViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoritePopularMovies = movieUseCase.getFavoritePopularMovies().asLiveData()
}