package com.example.ui.fragments.splash

import android.os.Handler
import android.os.Looper
import androidx.navigation.fragment.findNavController
import com.example.BuildConfig
import com.example.R
import com.example.base.BaseActivity
import com.example.base.BaseFragment
import com.example.databinding.FragmentSplashScreenBinding
import com.example.utils.PrefUtils.Companion.REMOTE_SHOW_NATIVE_LANGUAGE
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashScreenBinding>(
    R.layout.fragment_splash_screen, SplashViewModel::class.java
) {

    companion object {
        private enum class SplashType { OPEN_SPLASH, INTERSTITIAL, FAIL }

        private enum class FetchRemoteConfig { FETCHING, DONE, NONE }
    }

    private var splashLoadType: SplashType? = null
    private var fetchRemoteConfig: FetchRemoteConfig = FetchRemoteConfig.NONE
    private var errorShowAdsInBackground: Boolean = false
    private var finishedSplash = false

    override fun initListener() {
        viewModel.haveRecordBloodSugar.observe(this.viewLifecycleOwner) { hasRecordData ->
            hasRecordData?.let {
                if (hasRecordData) {
                    val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                    findNavController().navigate(action)
                } else {
                    val action = SplashFragmentDirections.actionSplashFragmentToWelcomeFragment()
                    findNavController().navigate(action)
                }
            }
        }
    }

    private fun setupRemoteConfig() {
        fetchRemoteConfig = FetchRemoteConfig.FETCHING
        val firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(5000)
            .setMinimumFetchIntervalInSeconds(if (BuildConfig.ENV_TEST) 3600 else 0).build()
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)

        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener(requireActivity()) { task ->
            if (task.isSuccessful) {
                val updated: Boolean = task.result
                if (updated) {
                    fetchDataRemote(firebaseRemoteConfig)
                }
            }
            fetchRemoteConfig = FetchRemoteConfig.DONE
            onShowSplashScreen()
        }.addOnFailureListener {
            fetchRemoteConfig = FetchRemoteConfig.DONE
            onShowSplashScreen()
        }
        loadSplash()
    }

    private fun fetchDataRemote(firebaseRemoteConfig: FirebaseRemoteConfig) {
        prefUtils.isShowNativeLanguage =
            firebaseRemoteConfig.getBoolean(REMOTE_SHOW_NATIVE_LANGUAGE)
    }

    private fun onShowSplashScreen() {
        if (fetchRemoteConfig == FetchRemoteConfig.DONE) {
            if (SplashType.OPEN_SPLASH == splashLoadType) {
                goToMainScreen()
                /*AppOpenManager.getInstance()
                    .showAppOpenSplash(
                        requireActivity() as AppCompatActivity?,
                        object : AdCallback() {
                            override fun onNextAction() {
                                super.onNextAction()
                                goToMainScreen()
                            }

                            override fun onAdFailedToShow(adError: AdError?) {
                                super.onAdFailedToShow(adError)
                                if ((requireActivity() as? BaseActivity<*, *>)?.isOnResume == false) {
                                    errorShowAdsInBackground = true
                                }
                                goToMainScreen()
                            }

                            override fun onAdClosed() {
                                super.onAdClosed()
                                goToMainScreen()
                            }
                        })*/
            } else if (SplashType.INTERSTITIAL == splashLoadType) {
                goToMainScreen()
                /*AperoAd.getInstance().onShowSplash(
                    requireActivity() as AppCompatActivity,
                    object : AperoAdCallback() {
                        override fun onNextAction() {
                            super.onNextAction()
                            goToMainScreen()
                        }

                        override fun onAdFailedToShow(adError: ApAdError?) {
                            super.onAdFailedToShow(adError)
                            if ((requireActivity() as? BaseActivity<*, *>)?.isOnResume == false) {
                                errorShowAdsInBackground = true
                            }
                            goToMainScreen()
                        }

                        override fun onAdClosed() {
                            super.onAdClosed()
                            goToMainScreen()
                        }
                    })*/
            } else if (SplashType.FAIL == splashLoadType) {
                goToMainScreen()
            }
        }
    }

    private fun loadSplash() {
        if (isNetworkConnected()) {
            goToMainScreen()
            /*AperoAd.getInstance().loadAppOpenSplashSameTime(
                requireContext(),
                BuildConfig.inter_splash,
                30000,
                5000,
                false,
                object : AperoAdCallback() {
                    override fun onAdFailedToLoad(adError: ApAdError?) {
                        super.onAdFailedToLoad(adError)
                        splashLoadType = SplashType.FAIL
                        if (fetchRemoteConfig == FetchRemoteConfig.DONE) {
                            goToMainScreen()
                        }
                    }

                    override fun onAdSplashReady() {
                        super.onAdSplashReady()
                        if (!isAdded) {
                            return
                        }
                        splashLoadType = SplashType.OPEN_SPLASH
                        onShowSplashScreen()
                    }

                    override fun onInterstitialLoad(interstitialAd: ApInterstitialAd?) {
                        super.onInterstitialLoad(interstitialAd)
                        if (!isAdded) {
                            return
                        }
                        splashLoadType = SplashType.INTERSTITIAL
                        onShowSplashScreen()
                    }

                    override fun onNextAction() {
                        super.onNextAction()
                        if (fetchRemoteConfig == FetchRemoteConfig.DONE) {
                            goToMainScreen()
                        }
                    }
                })*/
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                goToMainScreen()
            }, 2000)
        }
    }

    override fun onResume() {
        super.onResume()
        /*AppOpenManager.getInstance().disableAppResume()*/

        if (errorShowAdsInBackground) {
            errorShowAdsInBackground = false
            if (isNetworkConnected()) {
                /*onShowSplashScreen()*/
                goToMainScreen()
            } else {
                goToMainScreen()
            }
            return
        }

        // check conditional
        if (fetchRemoteConfig == FetchRemoteConfig.NONE) {
            setupRemoteConfig()
        }

        //if go onResume but not have action
        if (!finishedSplash) {
            if (splashLoadType == SplashType.OPEN_SPLASH) {
                goToMainScreen()
                /*AperoAd.getInstance().onCheckShowSplashPriorityWhenFail(
                    requireActivity() as AppCompatActivity, object : AperoAdCallback() {
                        override fun onNextAction() {
                            super.onNextAction()
                            goToMainScreen()
                        }

                        override fun onAdClosed() {
                            super.onAdClosed()
                            goToMainScreen()
                        }

                        override fun onAdFailedToShow(adError: ApAdError?) {
                            super.onAdFailedToShow(adError)
                            goToMainScreen()
                        }

                    }, 1000
                )*/
            } else if (splashLoadType == SplashType.INTERSTITIAL) {
                goToMainScreen()
                /*AperoAd.getInstance().onCheckShowSplashWhenFail(
                    requireActivity() as AppCompatActivity, object : AperoAdCallback() {
                        override fun onNextAction() {
                            super.onNextAction()
                            goToMainScreen()
                        }

                        override fun onAdClosed() {
                            super.onAdClosed()
                            goToMainScreen()
                        }

                        override fun onAdFailedToShow(adError: ApAdError?) {
                            super.onAdFailedToShow(adError)
                            goToMainScreen()
                        }

                    }, 1000
                )*/
            }
        }
    }

    private fun goToMainScreen() {
        if (!finishedSplash) {
            if ((requireActivity() as? BaseActivity<*, *>)?.isOnResume == false) {
                errorShowAdsInBackground = true
            }
            if (prefUtils.isShowLanguageFirstOpen) {
                val action = SplashFragmentDirections.actionSplashFragmentToLanguageFragment()
                findNavController().navigate(action)
            } else {
                if (prefUtils.isShowOnBoardingFirstOpen) {
                    val action = SplashFragmentDirections.actionSplashFragmentToOnBoardingFragment()
                    findNavController().navigate(action)
                } else if (prefUtils.profileId == -1L) {
                    val action =
                        SplashFragmentDirections.actionSplashFragmentToProfileEditFragment()
                    findNavController().navigate(action)
                } else {
                    viewModel.checkHaveDataRecord()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        /*AppOpenManager.getInstance().enableAppResume()*/
        finishedSplash = true
    }
}