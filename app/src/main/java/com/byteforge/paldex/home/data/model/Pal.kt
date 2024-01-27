package com.byteforge.paldex.home.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PalResponse(
    val id: Int,
    val key: String,
    val image: String,
    val name: String,
    val wiki: String,
    val types: List<String>,
    @Json(name = "imageWiki") val imageWiki: String,
    val suitability: List<SuitabilityResponse>,
    val drops: List<String>,
    val aura: AuraResponse,
    val description: String,
    val skills: List<SkillResponse>
)
