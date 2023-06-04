package com.example.di.module

import com.example.data.repository.GlucoseRepository
import com.example.data.repository.ProfileRepository
import com.example.db.datasource.interfacedatasource.IGlucoseDataSource
import com.example.db.datasource.interfacedatasource.IProfileDataSource
import com.example.network.api.interfaceapi.IProfileAPI
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProfileRepository(
        iProfileDataSource: IProfileDataSource,
        iProfileAPI: IProfileAPI
    ): ProfileRepository =
        ProfileRepository(iProfileDataSource, iProfileAPI)

    @Provides
    @Singleton
    fun provideGlucoseRepository(iGlucoseDataSource: IGlucoseDataSource): GlucoseRepository =
        GlucoseRepository(iGlucoseDataSource)
}