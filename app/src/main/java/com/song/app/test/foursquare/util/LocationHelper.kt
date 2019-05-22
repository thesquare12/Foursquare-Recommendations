package com.song.app.test.foursquare.util

import android.annotation.SuppressLint
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

class LocationHelper {

    interface LocationChangedListener {
        fun onLocation(latitude: Double?, longitude: Double?)
    }

    @SuppressLint("MissingPermission")
    fun findLocation(context: Context?, listener: LocationChangedListener) {
        val locationManager = context?.getSystemService(Context.LOCATION_SERVICE) as LocationManager?
        val lastKnownLocation = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
        lastKnownLocation?.let {
            listener.onLocation(it.latitude, it.longitude)
        }

        locationManager?.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, object : LocationListener {
            override fun onLocationChanged(location: Location?) {
                if (lastKnownLocation == null)
                    listener.onLocation(location?.latitude, location?.longitude)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }
        }, null)
    }
}