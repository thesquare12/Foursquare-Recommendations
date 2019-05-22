package com.song.app.test.foursquare.model.recommendation

import com.song.app.test.foursquare.model.Meta

data class RecommendationResult(
        val meta: Meta,
        val response: Recommendation
)