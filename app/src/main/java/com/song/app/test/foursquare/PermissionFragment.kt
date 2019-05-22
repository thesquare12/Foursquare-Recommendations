package com.song.app.test.foursquare

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.song.app.test.foursquare.databinding.FragmentPermissionBinding
import com.song.app.test.foursquare.util.hasLocationPermission
import com.song.app.test.foursquare.viewmodel.PermissionViewModel

class PermissionFragment: Fragment() {

    companion object {
        private const val REQUEST_CODE_ACCESS_FINE_LOCATION = 100
    }

    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView?.let {
            return it
        }

        val binding = FragmentPermissionBinding.inflate(inflater, container, false)

        val viewModel = ViewModelProviders.of(this).get(PermissionViewModel::class.java)
        viewModel.showPermissionSetting.observe(viewLifecycleOwner, Observer {
            requestPermission()
        })
        binding.viewModel = viewModel

        if (hasLocationPermission(activity?.applicationContext!!)) {
            navigateToList()
        }
        rootView = binding.root
        return binding.root
    }

    private fun requestPermission() {
        requestPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_ACCESS_FINE_LOCATION)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_ACCESS_FINE_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                navigateToList()
            }
        }
    }

    private fun navigateToList() {
        val direction = PermissionFragmentDirections.actionPermissionToList()
        findNavController().navigate(direction)
    }
}