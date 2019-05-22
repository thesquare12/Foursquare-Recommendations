package com.song.app.test.foursquare.api

interface ApiCallback<T> {

    fun onResponse(response: T)
    fun onFailure(t: Throwable)
}