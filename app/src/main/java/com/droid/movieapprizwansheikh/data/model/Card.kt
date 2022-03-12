package com.droid.movieapprizwansheikh.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Card() : Parcelable {
    @SerializedName("card_id")
    @Expose
    var cardId: String? = null

    @SerializedName("start_time")
    @Expose
    var startTime: Int? = null

    @SerializedName("end_time")
    @Expose
    var endTime: Int? = null

    @SerializedName("priority")
    @Expose
    var priority: Double? = null

    @SerializedName("hide_on_use")
    @Expose
    var hideOnUse: Boolean? = null

    @SerializedName("hide_on_use_for_seconds")
    @Expose
    var hideOnUseForSeconds: Int? = null

    @SerializedName("card_template")
    @Expose
    var cardTemplate: String? = null

    @SerializedName("poi_lat_long")
    @Expose
    var poiLatLong: String? = null

    @SerializedName("distance_threshold_in_meters")
    @Expose
    var distanceThresholdInMeters: Int? = null

    @SerializedName("content")
    @Expose
    var content: Content? = null

    constructor(parcel: Parcel) : this() {
        cardId = parcel.readString()
        startTime = parcel.readValue(Int::class.java.classLoader) as? Int
        endTime = parcel.readValue(Int::class.java.classLoader) as? Int
        priority = parcel.readValue(Double::class.java.classLoader) as? Double
        hideOnUse = parcel.readValue(Boolean::class.java.classLoader) as? Boolean
        hideOnUseForSeconds = parcel.readValue(Int::class.java.classLoader) as? Int
        cardTemplate = parcel.readString()
        poiLatLong = parcel.readString()
        distanceThresholdInMeters = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardId)
        parcel.writeValue(startTime)
        parcel.writeValue(endTime)
        parcel.writeValue(priority)
        parcel.writeValue(hideOnUse)
        parcel.writeValue(hideOnUseForSeconds)
        parcel.writeString(cardTemplate)
        parcel.writeString(poiLatLong)
        parcel.writeValue(distanceThresholdInMeters)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}