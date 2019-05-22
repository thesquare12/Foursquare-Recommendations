package com.song.app.test.foursquare.model.recommendation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Venue(
    val id: String,
    val name: String,
    val location: Location,
    var imageUrl: String,
    val categories: ArrayList<Category>
//    val likes: Like
) : Parcelable