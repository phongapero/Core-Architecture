package com.example.ui.fragments.container

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.R
import com.example.base.BaseFragment
import com.example.databinding.FragmentContainerBinding


class ContainerFragment : BaseFragment<ContainerViewModel, FragmentContainerBinding>(
    R.layout.fragment_container,
    ContainerViewModel::class.java
) {
    override fun initView() {
        super.initView()
        settBottomNavigation()
    }

    private fun settBottomNavigation() {
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)

        /*val bottomMenuView = binding.bottomNavigationView.getChildAt(0) as BottomNavigationMenuView
        val view = bottomMenuView.getChildAt(2)
        val itemView = view as BottomNavigationItemView

        val viewCustom = LayoutInflater.from(requireContext())
            .inflate(R.layout.bottom_view_add, bottomMenuView, false)


        viewCustom.findViewById<ImageButton>(R.id.btnAdd).clickWithDebounce {
            setupMenuBottomDialog()
        }
        itemView.addView(viewCustom)*/
    }
}