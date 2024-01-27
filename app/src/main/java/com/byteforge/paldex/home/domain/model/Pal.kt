package com.byteforge.paldex.home.domain.model

data class Pal(
    val id: Int,
    val key: String,
    val image: String,
    val name: String,
    val wiki: String,
    val types: List<String>,
    val imageWiki: String,
    val suitability: List<Suitability>,
    val drops: List<String>,
    val aura: Aura,
    val description: String,
    val skills: List<Skill>
)
