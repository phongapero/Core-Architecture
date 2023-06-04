package com.example.ui.fragments.onboarding

import android.os.Bundle
import com.example.R
import com.example.base.BaseFragment
import com.example.base.BaseViewModel
import com.example.databinding.FragmentOnboardingPageBinding

class OnBoardingPageFragment : BaseFragment<BaseViewModel, FragmentOnboardingPageBinding>(
    R.layout.fragment_onboarding_page,
    BaseViewModel::class.java
) {
    companion object {
        const val PHOTO = "photo"
        const val TITLE = "title"
        const val CONTENT = "content"
        fun newInstance(onboarding: Onboarding): OnBoardingPageFragment {

            val bundle = Bundle()
            bundle.putInt(PHOTO, onboarding.photo)
            bundle.putString(TITLE, onboarding.title)
            bundle.putString(CONTENT, onboarding.content)

            val fragment = OnBoardingPageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun initView() {
        val photo = arguments?.getString(PHOTO)
        val title = arguments?.getString(TITLE)
        val content = arguments?.getString(CONTENT)

        binding.elementTitle.text = title
        binding.elementContent.text = content
    }
}