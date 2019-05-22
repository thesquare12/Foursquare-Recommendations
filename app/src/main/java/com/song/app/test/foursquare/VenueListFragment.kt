package com.song.app.test.foursquare

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.song.app.test.foursquare.adapter.VenueListAdapter
import com.song.app.test.foursquare.databinding.FragmentListBinding
import com.song.app.test.foursquare.viewmodel.VenueListViewModel

class VenueListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: VenueListViewModel
    private lateinit var adapter: VenueListAdapter

    private var rootView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(VenueListViewModel::class.java)
        viewModel.list.observe(this, Observer {
            val isNullOrEmpty = it.isNullOrEmpty()
            binding.isNullOrEmpty = isNullOrEmpty
            if (!isNullOrEmpty)
                adapter.submitList(it)
        })
        viewModel.isLoading.observe(this, Observer {
            binding.layoutSwipeRefresh.isRefreshing = it
        })
        viewModel.errorEvent.observe(this, Observer {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView?.let {
            return it
        }
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.layoutSwipeRefresh.run {
            setOnRefreshListener {
                viewModel.loadData()
            }
        }

        (activity as AppCompatActivity).run {
            setSupportActionBar(binding.toolbar)
            setTitle(R.string.list_toolbar_title)
            setHasOptionsMenu(true)
        }

        adapter = VenueListAdapter()

        binding.recyclerview.adapter = adapter
        binding.viewModel = viewModel

        viewModel.loadData()

        rootView = binding.root
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        viewModel.sortByDistance = item?.itemId == R.id.menu_sort_by_distance
        return super.onOptionsItemSelected(item)
    }
}