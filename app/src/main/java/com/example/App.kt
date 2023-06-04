package com.example

import android.app.Application
import com.example.di.AppInjector
import com.example.firebase.FirebaseUtils
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * this class also implements AdsMultiDexApplication() class from Apero
 */
class App : Application(), HasAndroidInjector {
    companion object {
        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        /*val environment = if (BuildConfig.ENV_TEST) {
            AperoAdConfig.ENVIRONMENT_DEVELOP
        } else {
            AperoAdConfig.ENVIRONMENT_PRODUCTION
        }
        aperoAdConfig = AperoAdConfig(this, AperoAdConfig.PROVIDER_ADMOB, environment)
        aperoAdConfig.mediationProvider = AperoAdConfig.PROVIDER_ADMOB
        AppOpenManager.getInstance().setSplashAdId(BuildConfig.open_splash)
        app = this
        aperoAdConfig.idAdResume = BuildConfig.open_resume
        aperoAdConfig.listDeviceTest = listOf(
            "577C9208AEFF7C67F9A420B37E32681F"
        )
        listTestDevice.add("577C9208AEFF7C67F9A420B37E32681F")
        aperoAdConfig.listDeviceTest = listTestDevice

        val adjustConfig = AdjustConfig(true, "ADJUST_TOKEN")
        adjustConfig.eventAdImpression = "EVENT_AD_IMPRESSION_ADJUST"
        adjustConfig.eventNamePurchase = "EVENT_PURCHASE_ADJUST"
        aperoAdConfig.adjustConfig = adjustConfig

        AperoAd.getInstance().init(this, aperoAdConfig, false)

        Admob.getInstance().setFan(false)
        Admob.getInstance().setAppLovin(false)
        Admob.getInstance().setColony(false)
        Admob.getInstance().setOpenActivityAfterShowInterAds(true)*/

        //Firebase analytics
        /*FirebaseUtils.init(this)*/
    }

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}