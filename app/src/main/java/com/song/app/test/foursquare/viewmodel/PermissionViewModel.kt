package com.song.app.test.foursquare.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.song.app.test.foursquare.util.SingleLiveEvent

class PermissionViewModel: ViewModel() {

    private val _showPermissionSetting = SingleLiveEvent<Any>()
    val showPermissionSetting: LiveData<Any> get() = _showPermissionSetting

    fun showPermissionSetting() {
        _showPermissionSetting.call()
    }
}