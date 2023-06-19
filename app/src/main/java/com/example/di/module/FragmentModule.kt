package com.example.di.module

import com.example.ui.fragments.container.ContainerFragment
import com.example.ui.fragments.home.HomeFragment
import com.example.ui.fragments.info.InfoFragment
import com.example.ui.fragments.insight.InsightFragment
import com.example.ui.fragments.language.LanguageFragment
import com.example.ui.fragments.onboarding.OnBoardingFragment
import com.example.ui.fragments.onboarding.OnBoardingPageFragment
import com.example.ui.fragments.profile.ProfileEditFragment
import com.example.ui.fragments.setting.SettingFragment
import com.example.ui.fragments.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun splashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun languageFragment(): LanguageFragment

    @ContributesAndroidInjector
    abstract fun onBoardingFragment(): OnBoardingFragment

    @ContributesAndroidInjector
    abstract fun onBoardingPageFragment(): OnBoardingPageFragment

    @ContributesAndroidInjector
    abstract fun profileEditFragment(): ProfileEditFragment


    @ContributesAndroidInjector
    abstract fun containerFragment(): ContainerFragment

    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun insightFragment(): InsightFragment

    @ContributesAndroidInjector
    abstract fun infoFragment(): InfoFragment

    @ContributesAndroidInjector
    abstract fun settingFragment(): SettingFragment
}