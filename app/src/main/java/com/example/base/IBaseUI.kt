package com.example.base

interface IBaseUI {

    fun showLoading(content: String)

    fun hideLoading()

    fun isNetworkConnected(): Boolean

    fun hideSystemNavigationBar()
}