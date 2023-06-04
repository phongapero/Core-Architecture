package com.example.di.module

import com.example.ui.fragments.home.HomeFragment
import com.example.ui.fragments.language.LanguageFragment
import com.example.ui.fragments.onboarding.OnBoardingFragment
import com.example.ui.fragments.onboarding.OnBoardingPageFragment
import com.example.ui.fragments.profile.ProfileEditFragment
import com.example.ui.fragments.splash.SplashFragment
import com.example.ui.fragments.welcome.WelcomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun homeFragment(): HomeFragment

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
    abstract fun welcomeFragment(): WelcomeFragment
}