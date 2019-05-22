package com.song.app.test.foursquare.model.photo

import android.os.Parcelable
import com.song.app.test.foursquare.model.Meta
import kotlinx.android.parcel.Parcelize

@Parcelize
class PhotoResult(
        val meta: Meta,
        val response: PhotoResponse
) : Parcelable