package com.example.ui.fragments.home

import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    R.layout.fragment_home,
    HomeViewModel::class.java
) {

}