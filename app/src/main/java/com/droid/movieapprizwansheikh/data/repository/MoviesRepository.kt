package com.droid.movieapprizwansheikh.data.repository

import com.droid.movieapprizwansheikh.data.api.APIProvider
import com.droid.movieapprizwansheikh.data.model.MoviesModelResponse
import com.droid.movieapprizwansheikh.network.AppRetrofitAdapter.retrofit
import retrofit2.Response

/**
 * Created by RIZWAN on 12-Mar-22.
 */
class MoviesRepository {
    suspend fun moviesListData(): Response<MoviesModelResponse> =
        retrofit!!.create(APIProvider::class.java).getMoviesModel()

}