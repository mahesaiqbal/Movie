package com.mahesaiqbal.movie.core

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mahesaiqbal.movie.core.domain.repository.IMovieRepository
import com.mahesaiqbal.movie.core.domain.usecase.MovieInteractor
import com.mahesaiqbal.movie.core.domain.usecase.MovieUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieUseCaseTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieUseCase: MovieUseCase

    @Mock
    private lateinit var movieRepository: IMovieRepository

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        movieUseCase = MovieInteractor(movieRepository)
    }

    @Test
    fun `should get data from repository`() {
        movieUseCase.getPopularMovies()

        verify(movieRepository).getPopularMovies()
        verifyNoMoreInteractions(movieRepository)
    }
}