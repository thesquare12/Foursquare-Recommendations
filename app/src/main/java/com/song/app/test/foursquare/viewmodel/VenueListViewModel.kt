package com.song.app.test.foursquare.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.song.app.test.foursquare.api.ApiCallback
import com.song.app.test.foursquare.api.FoursquareApi
import com.song.app.test.foursquare.model.recommendation.GroupItem
import com.song.app.test.foursquare.model.recommendation.RecommendationResult
import com.song.app.test.foursquare.util.LocationHelper

class VenueListViewModel(application: Application) : AndroidViewModel(application) {

    private val mutableList = MutableLiveData<List<GroupItem>>()
    val list: LiveData<List<GroupItem>> get() = mutableList

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    var sortByDistance = true
        set(value) {
            field = value
            loadData()
        }

    fun loadData() {
        isLoading.postValue(true)
        LocationHelper().findLocation(getApplication(), object : LocationHelper.LocationChangedListener {
            override fun onLocation(latitude: Double?, longitude: Double?) {
                recommendations("food", sortByDistance, "$latitude,$longitude", 30)
            }
        })
    }

    private fun recommendations(section: String, sortByDistance: Boolean, location: String, limit: Int) {
        FoursquareApi().recommendations(object : ApiCallback<RecommendationResult> {
            override fun onResponse(response: RecommendationResult) {
                isLoading.postValue(false)
                mutableList.postValue(response.response.groups[0].items)
            }

            override fun onFailure(t: Throwable) {
                isLoading.postValue(false)
            }
        }, section, sortByDistance, location, limit)
    }

    fun onClickRetry(view: View) {
        loadData()
    }
}