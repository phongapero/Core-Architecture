package com.example.ui.fragments.splash

import androidx.lifecycle.viewModelScope
import com.example.base.BaseViewModel
import com.example.data.repository.GlucoseRepository
import com.example.utils.listener.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel : BaseViewModel() {

    @Inject
    lateinit var glucoseRepository: GlucoseRepository

    val haveRecordBloodSugar = SingleLiveEvent<Boolean?>().apply { value = null }

    fun checkHaveDataRecord() {
        viewModelScope.launch {
            try {
                withContext(Dispatchers.IO) {
                    val countGlucose =
                        glucoseRepository.countBloodSugarByProfileID(prefUtils.profileId)

                    haveRecordBloodSugar.postValue(countGlucose > 0)
                }
            } catch (ex: Exception) {
                haveRecordBloodSugar.postValue(false)
            }
        }
    }
}