package com.example.ui.fragments.onboarding

import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.R
import com.example.base.BaseFragment
import com.example.base.BaseViewModel
import com.example.databinding.FragmentOnboardingBinding
import com.example.ui.adapters.OnBoardingPageAdapter
import com.example.utils.ViewUtils.clickWithDebounce

class OnBoardingFragment : BaseFragment<BaseViewModel, FragmentOnboardingBinding>(
    R.layout.fragment_onboarding, BaseViewModel::class.java
) {

    var adapter: OnBoardingPageAdapter? = null

    override fun initializeAdvertisement() {
        /*if (isNetworkConnected()) {
            binding.nativeAdView.loadNativeAd(requireActivity(), BuildConfig.native_home)
        } else {
            binding.nativeAdView.makeGone()
        }*/
    }

    override fun initView() {

        val list = ArrayList<Onboarding>()
        val onboarding1 = Onboarding(R.drawable.ic_nazi_logo, requireContext().getString(R.string.dummy_title), requireContext().getString(R.string.dummy_content) )
        val onboarding2 = Onboarding(R.drawable.ic_nazi_logo, requireContext().getString(R.string.dummy_title), requireContext().getString(R.string.dummy_content))
        val onboarding3 = Onboarding(R.drawable.ic_nazi_logo, requireContext().getString(R.string.dummy_title), requireContext().getString(R.string.dummy_content))

        list.add(onboarding1)
        list.add(onboarding2)
        list.add(onboarding3)



        adapter = OnBoardingPageAdapter(childFragmentManager, list)
        binding.viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

    override fun initListener() {
        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int, positionOffset: Float, positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                /*if (position == OnBoardingPageAdapter.NUMBER_PAGE - 1) {
                    binding.tvNext.text = getString(R.string.start)
                } else {
                    binding.tvNext.text = getString(R.string.next)
                }*/
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

        binding.tvNext.clickWithDebounce {
            if (binding.viewPager.currentItem == adapter!!.count - 1) {
                prefUtils.isShowOnBoardingFirstOpen = false

                val action = OnBoardingFragmentDirections.actionOnBoardingFragmentToProfileEditFragment()
                action.allowBack = false
                action.mode = 10
                findNavController().navigate(action)
            } else {
                binding.viewPager.currentItem++
            }
        }
    }

    override fun onDestroyView() {
        binding.viewPager.adapter = null
        super.onDestroyView()
    }
}