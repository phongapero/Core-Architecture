package com.example.ui.fragments.language

import androidx.navigation.fragment.findNavController
import com.example.R
import com.example.base.BaseFragment
import com.example.base.BaseViewModel
import com.example.databinding.FragmentLanguageBinding
import com.example.ui.adapters.LanguageAdapter
import com.example.utils.ViewUtils.clickWithDebounce

class LanguageFragment : BaseFragment<BaseViewModel, FragmentLanguageBinding>(
    R.layout.fragment_language, BaseViewModel::class.java
) {
    private val adapter = LanguageAdapter()
    private var isDoneSplash = false

    override fun initData() {
        binding.recyclerView.adapter = adapter
    }

    override fun initializeAdvertisement() {
        checkShowNativeLanguage()
    }

    override fun initListener() {
        binding.ivConfirmLanguage.clickWithDebounce {
            val chooseLang = adapter.getSelectedLanguage()
            if (chooseLang != null) {
                prefUtils.currentLanguage = chooseLang.codeName
                prefUtils.isShowLanguageFirstOpen = false

                val action = LanguageFragmentDirections.actionLanguageFragmentToOnBoardingFragment()
                findNavController().navigate(action)
            } else {
                requireActivity().finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        isDoneSplash = true
    }

    private fun checkShowNativeLanguage() {
        /*if (prefUtils.isShowNativeLanguage) {
            AperoAd.getInstance().loadNativeAdResultCallback(requireActivity(),
                BuildConfig.native_language,
                R.layout.layout_native_control,
                object : AperoAdCallback() {
                    override fun onNativeAdLoaded(nativeAd: ApNativeAd) {
                        super.onNativeAdLoaded(nativeAd)
                        if (context != null) {
                            binding.layoutAdvertisement.makeVisible()
                            val adView = LayoutInflater.from(requireContext())
                                .inflate(R.layout.native_admod_ad, null) as NativeAdView
                            Admob.getInstance()
                                .populateUnifiedNativeAdView(nativeAd.admobNativeAd, adView)
                            binding.layoutAdvertisement.removeAllViews()
                            binding.layoutAdvertisement.addView(adView)
                        }
                    }

                    override fun onAdFailedToLoad(adError: ApAdError?) {
                        super.onAdFailedToLoad(adError)
                        binding.layoutAdvertisement.makeGone()
                    }
                })
        } else {
            binding.layoutAdvertisement.makeGone()
        }*/
    }
}