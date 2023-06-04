package com.example.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.base.BaseViewModel
import com.example.di.ViewModelFactory
import com.example.di.key.ViewModelKey
import com.example.ui.fragments.home.HomeViewModel
import com.example.ui.fragments.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(BaseViewModel::class)
    abstract fun provideBaseViewModel(baseViewModel: BaseViewModel): ViewModel


    @IntoMap
    @Binds
    @ViewModelKey(HomeViewModel::class)
    abstract fun provideHomeViewModel(homeViewModel: HomeViewModel): HomeViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SplashViewModel::class)
    abstract fun provideSplashViewModel(splashViewModel: SplashViewModel): SplashViewModel
}