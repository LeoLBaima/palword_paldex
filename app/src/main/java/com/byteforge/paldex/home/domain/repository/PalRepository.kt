package com.byteforge.paldex.home.domain.repository

import com.byteforge.paldex.home.domain.model.Pal

abstract class PalRepository {
    abstract fun getPals(): List<Pal>
}