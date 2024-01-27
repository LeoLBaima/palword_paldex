package com.byteforge.paldex.home.data.datasource

import android.content.Context
import com.byteforge.paldex.home.data.model.PalResponse
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.coroutines.delay
import java.io.IOException

class LocalDataSource(private val context: Context) {

    fun getPals(): List<PalResponse> {
        val jsonString: String
        try {
            jsonString = context.assets.open("pals.json").bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return emptyList()
        }

        val listType = Types.newParameterizedType(List::class.java, PalResponse::class.java)
        val adapter: JsonAdapter<List<PalResponse>> = Moshi.Builder().build().adapter(listType)

        return adapter.fromJson(jsonString) ?: emptyList()
    }
}