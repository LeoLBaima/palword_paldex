package com.byteforge.paldex.home.data.mapper

import com.byteforge.paldex.home.data.model.AuraResponse
import com.byteforge.paldex.home.domain.model.Aura
import javax.inject.Inject

class AuraMapper @Inject constructor() {

    fun mapFromNetworkModel(networkModel: AuraResponse): Aura {
        return Aura(
            name = networkModel.name,
            description = networkModel.description
        )
    }
}