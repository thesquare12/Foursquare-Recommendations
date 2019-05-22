package com.song.app.test.foursquare.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("icon")
fun bindVenueImage(view: ImageView, imageUrl: String) {
    // This API has a limit of 50 API calls per day
//    FoursquareApi().getPhoto(object : ApiCallback<PhotoResult> {
//        override fun onResponse(response: PhotoResult) {
//            val url = response.response.photos.items?.get(0)?.prefix + view.width + "x" + view.height + response.response.photos.items?.get(0)?.suffix
//            Glide.with(view.context)
//                    .load(url)
//                    .transition(DrawableTransitionOptions.withCrossFade())
//                    .into(view)
//        }
//
//        override fun onFailure(t: Throwable) {
//
//        }
//    }, venueId)

    Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) View.GONE else View.VISIBLE
}