package com.mahesaiqbal.movie.di

import com.mahesaiqbal.movie.core.domain.usecase.MovieInteractor
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase
import com.mahesaiqbal.movie.ui.detail.DetailMovieViewModel
import com.mahesaiqbal.movie.ui.favorite.FavoriteMovieViewModel
import com.mahesaiqbal.movie.ui.popular.PopularMovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { PopularMovieViewModel(get()) }
    viewModel { FavoriteMovieViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}