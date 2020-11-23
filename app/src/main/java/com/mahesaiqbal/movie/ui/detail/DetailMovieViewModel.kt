package com.mahesaiqbal.movie.ui.detail

import androidx.lifecycle.ViewModel
import com.mahesaiqbal.movie.core.domain.model.Movie
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoritePopularMovie(movie: Movie, newState: Boolean) =
        movieUseCase.setFavoritePopularMovie(movie, newState)
}