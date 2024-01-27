package com.byteforge.paldex.home.data.repository

import com.byteforge.paldex.home.data.mapper.PalMapper
import com.byteforge.paldex.home.data.service.PalService
import com.byteforge.paldex.home.domain.model.Pal
import com.byteforge.paldex.home.domain.repository.PalRepository
import javax.inject.Inject

class PalRepositoryImpl @Inject constructor(
    private val palService: PalService,
    private val palMapper: PalMapper
) : PalRepository() {

    override fun getPals(): List<Pal> {
        val palResponses = palService.getPals()
        return palResponses.map { palMapper.mapFromNetworkModel(it) }
    }
}