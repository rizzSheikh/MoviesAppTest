package com.droid.movieapprizwansheikh.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.droid.movieapprizwansheikh.databinding.ActivityMovieDetailsBinding

class MovieDetails : AppCompatActivity() {

    private lateinit var _binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        supportActionBar?.hide()

        val content = intent.extras?.getSerializable("content")

        if (content != null) {
            Toast.makeText(this, "Data Available", Toast.LENGTH_SHORT).show()
        }

    }
}