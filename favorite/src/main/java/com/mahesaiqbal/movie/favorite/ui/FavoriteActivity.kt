package com.mahesaiqbal.movie.favorite.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.mahesaiqbal.movie.core.ui.MovieAdapter
import com.mahesaiqbal.movie.favorite.databinding.ActivityFavoriteBinding
import com.mahesaiqbal.movie.favorite.di.favoriteModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModule)

        supportActionBar?.title = "Favorite Movie"

        getFavoriteMovie()
    }

    private fun getFavoriteMovie() {
        val movieAdapter = MovieAdapter()
        movieAdapter.onItemClick = { selectedData ->
            Toast.makeText(this, selectedData.title, Toast.LENGTH_SHORT).show()
        }

        viewModel.favoritePopularMovies.observe(this, { movie ->
            movieAdapter.setData(movie)
            binding.rlViewEmpty.visibility = if (movie.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvFavoriteMovie) {
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = movieAdapter
        }
    }
}