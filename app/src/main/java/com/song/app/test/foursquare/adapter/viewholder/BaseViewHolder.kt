package com.song.app.test.foursquare.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.song.app.test.foursquare.model.DetailContent

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(detailContent: DetailContent)
}