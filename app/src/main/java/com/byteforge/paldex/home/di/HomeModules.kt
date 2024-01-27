package com.byteforge.paldex.home.di

import android.app.Application
import android.content.Context
import com.byteforge.paldex.home.data.datasource.LocalDataSource
import com.byteforge.paldex.home.data.datasource.PalDataSource
import com.byteforge.paldex.home.data.mapper.PalMapper
import com.byteforge.paldex.home.data.repository.PalRepositoryImpl
import com.byteforge.paldex.home.data.service.PalService
import com.byteforge.paldex.home.domain.repository.PalRepository
import com.byteforge.paldex.home.presentation.HomeViewModel
import dagger.Module
import dagger.Provides

@Module
class HomeModules {

    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun providePalMapper(): PalMapper {
        return PalMapper()
    }

    @Provides
    fun provideLocalDataSource(context: Context): LocalDataSource {
        return LocalDataSource(context)
    }

    @Provides
    fun providePalDataSource(localDataSource: LocalDataSource): PalDataSource {
        return PalDataSource(localDataSource)
    }

    @Provides
    fun providePalService(palDataSource: PalDataSource): PalService {
        return PalService(palDataSource)
    }

    @Provides
    fun providePalRepository(palService: PalService, palMapper: PalMapper): PalRepository {
        return PalRepositoryImpl(palService, palMapper)
    }

    @Provides
    fun provideHomeViewModel(palRepository: PalRepository): HomeViewModel {
        return HomeViewModel(palRepository)
    }
}