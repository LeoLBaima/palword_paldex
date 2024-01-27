package com.byteforge.paldex.home.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SkillResponse(
    val level: Int,
    val name: String,
    val type: String,
    val cooldown: Int,
    val power: Int,
    val description: String
)
