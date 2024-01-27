package com.byteforge.paldex.home.data.mapper

import com.byteforge.paldex.home.data.model.SuitabilityResponse
import com.byteforge.paldex.home.domain.model.Suitability
import javax.inject.Inject

class SuitabilityMapper @Inject constructor() {

    fun mapFromNetworkModel(networkModel: SuitabilityResponse): Suitability {
        return Suitability(
            type = networkModel.type,
            level = networkModel.level
        )
    }
}