package com.song.app.test.foursquare.api

import com.song.app.test.foursquare.common.CLIENT_ID
import com.song.app.test.foursquare.common.CLIENT_SECRET
import com.song.app.test.foursquare.model.photo.PhotoResult
import com.song.app.test.foursquare.model.recommendation.RecommendationResult
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FoursquareApi : BaseApi() {

    fun recommendations(callback: ApiCallback<RecommendationResult>,
                        section: String,
                        sortByDistance: Boolean,
                        latitudeAndLongitude: String,
                        limit: Int): Disposable =
            createService(FoursquareService::class.java).searchRecommendation(
                    CLIENT_ID,
                    CLIENT_SECRET,
                    date(),
                    section,
                    if (sortByDistance) 1 else 0,
                    latitudeAndLongitude,
                    limit)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        callback.onResponse(it)
                    }) {
                        callback.onFailure(it)
                    }

    fun getPhoto(callback: ApiCallback<PhotoResult>,
                 venueId: String): Disposable =
            createService(FoursquareService::class.java).getPhoto(
                    venueId,
                    CLIENT_ID,
                    CLIENT_SECRET,
                    date())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        callback.onResponse(it)
                    }) {
                        callback.onFailure(it)
                    }
}