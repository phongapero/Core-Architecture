package com.example.ui.fragments.home

import com.example.R
import com.example.base.BaseFragment
import com.example.base.BaseViewModel
import com.example.databinding.FragmentContainerBinding


class HomeFragment : BaseFragment<BaseViewModel, FragmentContainerBinding>(
    R.layout.fragment_home,
    BaseViewModel::class.java
) {

}