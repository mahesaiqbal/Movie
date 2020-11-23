package com.mahesaiqbal.movie.ui.popular

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.mahesaiqbal.movie.core.data.Resource
import com.mahesaiqbal.movie.databinding.FragmentPopularMovieBinding
import com.mahesaiqbal.movie.core.ui.MovieAdapter
import com.mahesaiqbal.movie.ui.detail.DetailMovieActivity
import org.koin.android.viewmodel.ext.android.viewModel

class PopularMovieFragment : Fragment() {

    private val viewModel: PopularMovieViewModel by viewModel()

    private lateinit var binding: FragmentPopularMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val movieAdapter = MovieAdapter()
            movieAdapter.onItemClick = { selectedData ->
                val intent = Intent(activity, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.MOVIE_DATA, selectedData)
                startActivity(intent)
            }

            viewModel.popularMovies.observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                        is Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            movieAdapter.setData(movie.data)
                        }
                        is Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(activity, "Resource Error", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            })

            with(binding.rvPopularMovie) {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = movieAdapter
            }
        }
    }
}