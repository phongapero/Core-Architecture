package com.example.ui.fragments.welcome

import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentWelcomeBinding
import com.example.ui.fragments.profile.ProfileViewModel
import com.example.utils.ViewUtils.clickWithDebounce

class WelcomeFragment : BaseFragment<ProfileViewModel, FragmentWelcomeBinding>(
    R.layout.fragment_welcome, ProfileViewModel::class.java
) {

    override fun initListener() {
        binding.btnGlucose.clickWithDebounce {

        }

        binding.btnConvert.clickWithDebounce {

        }
    }
}