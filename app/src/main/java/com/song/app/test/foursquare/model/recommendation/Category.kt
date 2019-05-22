package com.song.app.test.foursquare.model.recommendation

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
        val id: String,
        val name: String
) : Parcelable