package com.example.di.module

import com.example.di.scope.PerActivity
import com.example.ui.activities.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentModule::class])
    internal abstract fun mainActivity(): MainActivity
}