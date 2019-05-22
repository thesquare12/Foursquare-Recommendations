package com.song.app.test.foursquare.model.photo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(
        val count: Int,
        val items: ArrayList<PhotoItem>
) : Parcelable