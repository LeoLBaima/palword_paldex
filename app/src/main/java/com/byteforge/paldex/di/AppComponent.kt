package com.byteforge.paldex.di

import android.app.Application
import com.byteforge.paldex.home.di.HomeModules
import com.byteforge.paldex.home.presentation.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HomeModules::class])
interface AppComponent {
    fun inject(activity: HomeActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}