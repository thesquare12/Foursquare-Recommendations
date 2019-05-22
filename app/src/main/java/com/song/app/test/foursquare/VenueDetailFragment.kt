package com.song.app.test.foursquare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.song.app.test.foursquare.adapter.DetailListAdapter
import com.song.app.test.foursquare.databinding.FragmentDetailBinding
import com.song.app.test.foursquare.model.DetailContent
import com.song.app.test.foursquare.viewmodel.VenueDetailViewModel

class VenueDetailFragment : Fragment() {

    private val args: VenueDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.item = args.item

        val adapter = DetailListAdapter()
        binding.recyclerview.adapter = adapter

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        val viewModel = ViewModelProviders.of(this).get(VenueDetailViewModel::class.java)
        viewModel.data.observe(viewLifecycleOwner, Observer {
            it.apply {
                val list: ArrayList<DetailContent> = arrayListOf(
                        DetailContent("id", venue.id),
                        DetailContent("이름", venue.name),
                        DetailContent("주소", venue.location.state + " " + venue.location.city + " " + venue.location.address),
                        DetailContent("카테고리", venue.categories?.first()?.name)
                )
                adapter.submitList(list)
            }
        })
        viewModel.submit(args.item)

        return binding.root
    }
}