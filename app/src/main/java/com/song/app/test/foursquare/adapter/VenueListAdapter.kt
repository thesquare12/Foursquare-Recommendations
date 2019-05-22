package com.song.app.test.foursquare.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.song.app.test.foursquare.VenueListFragmentDirections
import com.song.app.test.foursquare.databinding.ListItemVenueBinding
import com.song.app.test.foursquare.model.recommendation.GroupItem

class VenueListAdapter : ListAdapter<GroupItem, VenueListAdapter.ViewHolder>(VenueDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemVenueBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        // Foursquare Photo API has a limit of 50 calls per day
        // So, hard-coded URL is used instead of the URL from the API
        item.venue.imageUrl = "https://fastly.4sqi.net/img/general/1080x420/1132764_2iqW05A02FsTLKx7etNVRtCtZ2mgGT8osF2gM3E0Ihw.jpg"
        holder.apply {
            bind(createOnClickListener(item), item)
        }
    }

    private fun createOnClickListener(groupItem: GroupItem): View.OnClickListener {
        return View.OnClickListener {
            val direction = VenueListFragmentDirections.actionListToDetail(groupItem)
            it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(private val binding: ListItemVenueBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, groupItemParam: GroupItem) {
            binding.apply {
                clickListener = listener
                groupItem = groupItemParam
                executePendingBindings()
            }
        }
    }
}

private class VenueDiffCallback : DiffUtil.ItemCallback<GroupItem>() {

    override fun areItemsTheSame(oldItem: GroupItem, newItem: GroupItem): Boolean {
        return oldItem.venue.id == newItem.venue.id
    }

    override fun areContentsTheSame(oldItem: GroupItem, newItem: GroupItem): Boolean {
        return oldItem.venue.id == newItem.venue.id &&
                oldItem.venue.name == newItem.venue.name
    }
}