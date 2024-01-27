package com.byteforge.paldex.home.data.datasource

import com.byteforge.paldex.home.data.model.PalResponse
import javax.inject.Inject

class PalDataSource @Inject constructor(private val localDataSource: LocalDataSource) {
    fun getPals(): List<PalResponse> {
        //Future when a remote data source is added, we can add it here
        //Would be something like:
        //return remoteDataSource.getPals() ?: localDataSource.getPals()
        return localDataSource.getPals()
    }
}