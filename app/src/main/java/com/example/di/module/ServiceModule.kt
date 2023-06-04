package com.example.di.module

import com.example.ui.services.ServiceManager
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceModule {

    @ContributesAndroidInjector
    abstract fun serviceManager(): ServiceManager
}