package com.mahesaiqbal.movie.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.mahesaiqbal.movie.R
import com.mahesaiqbal.movie.core.domain.model.Movie
import com.mahesaiqbal.movie.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val MOVIE_DATA = "movie_data"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    private val viewModel: DetailMovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieData = intent.getParcelableExtra<Movie>(MOVIE_DATA)
        showMovieDetail(movieData)
    }

    private fun showMovieDetail(movieData: Movie?) {

        movieData?.let {
            binding.toolbarLayout.title = movieData.title
            binding.contentDetailMovie.tvDetailDescription.text = movieData.overview
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/original${movieData.posterPath}")
                .into(binding.ivDetailImage)

            var statusFavorite = movieData.isFavorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                viewModel.setFavoritePopularMovie(movieData, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_not_favorite_white))
        }
    }
}