package com.mahesaiqbal.movie.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mahesaiqbal.movie.core.databinding.ItemListMovieBinding
import com.mahesaiqbal.movie.core.domain.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    private var listData = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemListMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int = listData.size

    inner class ViewHolder(binding: ItemListMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        private val imgPoster = binding.imgPoster
        private val tvTitle = binding.tvTitle

        fun bind(data: Movie) {
            Glide.with(itemView.context)
                .load("https://image.tmdb.org/t/p/w500${data.posterPath}")
                .override(500, 500)
                .into(imgPoster)

            tvTitle.text = data.title
        }

        init {
            imgPoster.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}