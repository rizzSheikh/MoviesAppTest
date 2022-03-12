package com.droid.movieapprizwansheikh.viewmodel

import android.util.Log
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droid.movieapprizwansheikh.data.model.Data
import com.droid.movieapprizwansheikh.data.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by RIZWAN on 12-Mar-22.
 */
class MoviesViewModel : ViewModel() {

    private val TAG = "MoviesViewModel"

    private var repository: MoviesRepository = MoviesRepository()
    var moviesData: MutableLiveData<Data> = MediatorLiveData()

    fun getMoviesData() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.moviesListData().let {
                if (it.isSuccessful) {
                    moviesData.postValue(it.body()?.data)
                } else {
                    Log.d(TAG, "API CALL FAILED")
                }
            }
        }
    }

}