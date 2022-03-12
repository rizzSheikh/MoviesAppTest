package com.droid.movieapprizwansheikh.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.droid.movieapprizwansheikh.adapters.MoviesListAdapter
import com.droid.movieapprizwansheikh.databinding.ActivityMainBinding
import com.droid.movieapprizwansheikh.viewmodel.MoviesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    val viewModel: MoviesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportActionBar?.title = "Movies APP"

        _binding.progressBar.visibility = View.VISIBLE

        _binding.swipeToRefreshView.setOnRefreshListener {
            _binding.swipeToRefreshView.isRefreshing = true
            _binding.progressBar.visibility = View.VISIBLE
            _binding.recyclerView.visibility = View.GONE
            viewModel.getMoviesData()
        }

        viewModel.getMoviesData()

        viewModel.moviesData.observe(this) {
            if ((it.cards?.size ?: -1) > 0) {
                _binding.recyclerView.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                _binding.swipeToRefreshView.isRefreshing = false
                _binding.progressBar.visibility = View.GONE
                _binding.recyclerView.visibility = View.VISIBLE
                _binding.recyclerView.adapter = MoviesListAdapter(MainActivity@ this, it.cards!!)
            } else {
                Toast.makeText(MainActivity@ this, "No Dat Found", Toast.LENGTH_SHORT).show()
            }
        }

    }
}