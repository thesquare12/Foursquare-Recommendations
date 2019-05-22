package com.song.app.test.foursquare.model.photo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class PhotoResponse(
        val photos: Photo
) : Parcelable