package com.byteforge.paldex.home.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SuitabilityResponse(
    val type: String,
    val level: Int
)