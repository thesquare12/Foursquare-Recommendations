package com.song.app.test.foursquare.model.recommendation

data class Recommendation(
        val suggestedRadius: Int,
        val totalResults: Int,
        val groups: ArrayList<Group>
)