package com.droid.movieapprizwansheikh.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Content() : Serializable {
    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("movie_logo")
    @Expose
    var movieLogo: String? = null

    @SerializedName("rating")
    @Expose
    var rating: Double? = null

    @SerializedName("actions")
    @Expose
    var actions: List<Action>? = null

}