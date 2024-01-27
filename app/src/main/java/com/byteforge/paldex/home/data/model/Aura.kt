package com.byteforge.paldex.home.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuraResponse(
    val name: String,
    val description: String
)

