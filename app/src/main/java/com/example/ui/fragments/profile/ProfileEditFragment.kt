package com.example.ui.fragments.profile

import androidx.navigation.fragment.findNavController
import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentProfileEditBinding
import com.example.utils.ViewUtils.clickWithDebounce

class ProfileEditFragment : BaseFragment<ProfileViewModel, FragmentProfileEditBinding>(
    R.layout.fragment_profile_edit, ProfileViewModel::class.java
) {

    override fun initListener() {
        binding.btnSaveProfile.clickWithDebounce {
            prefUtils.profileId = 1

            val action = ProfileEditFragmentDirections.actionProfileEditFragmentToContainerFragment()
            findNavController().navigate(action)
        }
    }
}