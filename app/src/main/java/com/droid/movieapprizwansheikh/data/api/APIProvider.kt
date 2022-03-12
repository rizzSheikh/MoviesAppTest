package com.droid.movieapprizwansheikh.data.api

import com.droid.movieapprizwansheikh.data.model.MoviesModelResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by RIZWAN on 12-Mar-22.
 */
interface APIProvider {

    @GET("interview_ios.json")
    suspend fun getMoviesModel(): Response<MoviesModelResponse>
}