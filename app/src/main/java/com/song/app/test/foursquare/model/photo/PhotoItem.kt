package com.song.app.test.foursquare.model.photo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoItem(
        val prefix: String,
        val suffix: String,
        val width: Int,
        val height: Int
) : Parcelable