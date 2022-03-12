package com.droid.movieapprizwansheikh.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import java.io.Serializable

class Action :Serializable{
    @SerializedName("description")
    @Expose
    var description: String? = null

    @SerializedName("deeplink")
    @Expose
    var deeplink: String? = null
}