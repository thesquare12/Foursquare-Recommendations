package com.song.app.test.foursquare.model.recommendation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
        val lat: Double,
        val lng: Double,
        val distance: Int,
        val country: String,
        val state: String,
        val city: String,
        val address: String
) : Parcelable {

    fun formatDistance() =
            when {
                distance > 1000 -> String.format("%.1f", distance / 1000.0) + "km"
                else -> distance.toString() + "m"
            }
}