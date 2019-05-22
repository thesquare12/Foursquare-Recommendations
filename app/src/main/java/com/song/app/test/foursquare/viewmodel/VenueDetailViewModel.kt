package com.song.app.test.foursquare.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.song.app.test.foursquare.model.recommendation.GroupItem

class VenueDetailViewModel : ViewModel() {

    private val _data = MutableLiveData<GroupItem>()
    val data: LiveData<GroupItem> get() = _data

    fun submit(item: GroupItem) {
        _data.postValue(item)
    }
}