package com.song.app.test.foursquare.adapter

import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

@BindingAdapter("detailTitle")
fun bindDetailTitle(view: Toolbar, title: String) {
    view.title = title
}

@BindingAdapter("detailPhoto")
fun bindDetailPhoto(view: ImageView, imageUrl: String) {
    Glide.with(view.context)
            .load(imageUrl)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
}