package com.example.ui.fragments.setting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.R
import com.example.base.BaseFragment
import com.example.base.BaseViewModel
import com.example.databinding.FragmentContainerBinding
import com.example.databinding.FragmentSettingBinding


class SettingFragment : BaseFragment<BaseViewModel, FragmentSettingBinding>(
    R.layout.fragment_setting,
    BaseViewModel::class.java
), SettingAdapter.Callback {
    override fun initView() {
        super.initView()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val adapter = SettingAdapter(this)
        binding.recyclerView.adapter = adapter
    }

    override fun setupLanguage() {
        Toast.makeText(context, "Hi", Toast.LENGTH_SHORT).show()
    }
}