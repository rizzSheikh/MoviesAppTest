package com.droid.movieapprizwansheikh.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.droid.movieapprizwansheikh.data.model.Card
import com.droid.movieapprizwansheikh.databinding.MoviesItemBinding
import com.droid.movieapprizwansheikh.ui.MovieDetails

/**
 * Created by RIZWAN on 12-Mar-22.
 */
class MoviesListAdapter internal constructor(
    private val context: Context,
    private val dataList: List<Card>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private lateinit var itemBinding: MoviesItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        itemBinding = MoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MoviesViewHolder) {
            holder.bindData(position, dataList, context)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MoviesViewHolder(var itemBinding: MoviesItemBinding) : RecyclerView.ViewHolder(
        itemBinding.root
    ) {

        fun bindData(pos: Int, dataList: List<Card>, context: Context) {
            itemBinding.movieTitle.text = dataList[pos].content!!.title
            itemBinding.movieDescription.text = dataList[pos].content!!.description
            itemBinding.ratingBar.rating = dataList[pos].content!!.rating!!.toFloat()
            itemBinding.moviePosterView.setImageURI(Uri.parse(dataList[pos].content!!.movieLogo))

            itemBinding.mainItemView.setOnClickListener {
                val intent = Intent(context, MovieDetails::class.java)
                intent.putExtra("content", dataList[pos].content)
                context.startActivity(intent)
            }
        }
    }
}