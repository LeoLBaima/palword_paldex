package com.byteforge.paldex.home.domain.model

data class Skill(
    val level: Int,
    val name: String,
    val type: String,
    val cooldown: Int,
    val power: Int,
    val description: String
)
