package com.byteforge.paldex.home.data.service

import com.byteforge.paldex.home.data.datasource.PalDataSource
import com.byteforge.paldex.home.data.model.PalResponse
import javax.inject.Inject

class PalService @Inject constructor(private val palDataSource: PalDataSource) {

    fun getPals(): List<PalResponse> {
        return palDataSource.getPals()
    }
}