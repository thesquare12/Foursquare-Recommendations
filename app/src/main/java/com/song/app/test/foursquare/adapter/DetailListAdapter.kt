package com.song.app.test.foursquare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.song.app.test.foursquare.adapter.viewholder.BaseViewHolder
import com.song.app.test.foursquare.adapter.viewholder.DetailItemHolder
import com.song.app.test.foursquare.databinding.ListItemDetailContentBinding
import com.song.app.test.foursquare.model.DetailContent

class DetailListAdapter : ListAdapter<DetailContent, BaseViewHolder>(DetailDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
            DetailItemHolder(ListItemDetailContentBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

private class DetailDiffCallback : DiffUtil.ItemCallback<DetailContent>() {

    override fun areItemsTheSame(oldItem: DetailContent, newItem: DetailContent) = true

    override fun areContentsTheSame(oldItem: DetailContent, newItem: DetailContent) = true
}
