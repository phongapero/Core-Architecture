package com.example.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.ui.fragments.onboarding.OnBoardingPageFragment
import com.example.ui.fragments.onboarding.Onboarding

class OnBoardingPageAdapter(fm: FragmentManager, val list: ArrayList<Onboarding>) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        val PAGE_INDEX_1 = 0
        val PAGE_INDEX_2 = 1
        val PAGE_INDEX_3 = 2

        val NUMBER_PAGE = 2
    }

    override fun getItem(position: Int): Fragment {
        val onboarding = list[position]

        val fragment = OnBoardingPageFragment.newInstance(onboarding)
        return fragment
    }

    override fun getCount(): Int {
        return NUMBER_PAGE
    }

    override fun getPageTitle(position: Int): CharSequence {
        return "$position"
    }

}