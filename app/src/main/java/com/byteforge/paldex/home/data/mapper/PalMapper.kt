package com.byteforge.paldex.home.data.mapper

import com.byteforge.paldex.home.data.model.PalResponse
import com.byteforge.paldex.home.domain.model.Pal
import javax.inject.Inject

class PalMapper @Inject constructor() {
    private val suitabilityMapper = SuitabilityMapper()
    private val skillMapper = SkillMapper()
    private val auraMapper = AuraMapper()

    fun mapFromNetworkModel(pal: PalResponse): Pal {
        return Pal(
            id = pal.id,
            key = pal.key,
            image = pal.image,
            name = pal.name,
            wiki = pal.wiki,
            types = pal.types,
            imageWiki = pal.imageWiki,
            suitability = pal.suitability.map { suitabilityMapper.mapFromNetworkModel(it) },
            drops = pal.drops,
            aura = auraMapper.mapFromNetworkModel(pal.aura),
            description = pal.description,
            skills = pal.skills.map { skillMapper.mapFromNetworkModel(it) }
        )
    }
}