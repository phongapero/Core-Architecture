package com.example.ui.activities

import com.example.R
import com.example.base.BaseActivity
import com.example.base.BaseViewModel
import com.example.databinding.ActivityMainBinding

class MainActivity : BaseActivity<BaseViewModel, ActivityMainBinding>(
    R.layout.activity_main,
    BaseViewModel::class.java
) {

}