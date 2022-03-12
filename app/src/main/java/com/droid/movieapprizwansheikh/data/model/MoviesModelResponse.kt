package com.droid.movieapprizwansheikh.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MoviesModelResponse {
    @SerializedName("data")
    @Expose
    var data: Data? = null

    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    @SerializedName("errors")
    @Expose
    var errors: List<Any>? = null
}