package com.byteforge.paldex

import android.app.Application
import com.byteforge.paldex.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .build()
    }
}