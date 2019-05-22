package com.song.app.test.foursquare.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Meta(
        val code: Int,
        val requestId: String
) : Parcelable