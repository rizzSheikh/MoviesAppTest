package com.droid.movieapprizwansheikh.data.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Data {
    @SerializedName("cards")
    @Expose
    var cards: List<Card>? = null
}