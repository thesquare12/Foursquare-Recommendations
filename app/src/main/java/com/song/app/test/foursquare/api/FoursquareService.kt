package com.song.app.test.foursquare.api

import com.song.app.test.foursquare.model.photo.PhotoResult
import com.song.app.test.foursquare.model.recommendation.RecommendationResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoursquareService {

    @GET("venues/explore")
    fun searchRecommendation(
            @Query("client_id") clientID: String,
            @Query("client_secret") clientSecret: String,
            @Query("v") date: String,
            @Query("section") section: String,
            @Query("sortByDistance") sortByDistance: Int,
            @Query("ll") ll: String,
            @Query("limit") limit: Int
    ): Observable<RecommendationResult>

    @GET("venues/{venueId}/photos")
    fun getPhoto(
            @Path("venueId") venueId: String,
            @Query("client_id") clientID: String,
            @Query("client_secret") clientSecret: String,
            @Query("v") date: String
    ): Observable<PhotoResult>
}