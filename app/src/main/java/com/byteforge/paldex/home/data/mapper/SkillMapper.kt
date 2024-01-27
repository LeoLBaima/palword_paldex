package com.byteforge.paldex.home.data.mapper

import com.byteforge.paldex.home.data.model.SkillResponse
import com.byteforge.paldex.home.domain.model.Skill
import javax.inject.Inject

class SkillMapper @Inject constructor() {

    fun mapFromNetworkModel(networkModel: SkillResponse): Skill {
        return Skill(
            level = networkModel.level,
            name = networkModel.name,
            type = networkModel.type,
            cooldown = networkModel.cooldown,
            power = networkModel.power,
            description = networkModel.description
        )
    }
}