package com.song.app.test.foursquare.adapter.viewholder

import com.song.app.test.foursquare.databinding.ListItemDetailContentBinding
import com.song.app.test.foursquare.model.DetailContent

class DetailItemHolder(private val binding: ListItemDetailContentBinding) : BaseViewHolder(binding.root) {

    override fun bind(detailContent: DetailContent) {
        with(binding) {
            title = detailContent.title
            content = detailContent.content
            executePendingBindings()
        }
    }
}