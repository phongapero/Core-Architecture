package com.example.base

import androidx.lifecycle.ViewModel
import com.example.utils.PrefUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject

open class BaseViewModel @Inject internal constructor() : ViewModel() {

    @Suppress("unused")
    protected var viewModelJob = Job()

    @Suppress("unused")
    protected val ioContext = viewModelJob + Dispatchers.IO // background context

    @Suppress("unused")
    protected val uiContext = viewModelJob + Dispatchers.Main // ui context

    protected val ioScope = CoroutineScope(ioContext)

    @Suppress("unused")
    protected val uiScope = CoroutineScope(uiContext)

    @Inject
    lateinit var prefUtils: PrefUtils
}