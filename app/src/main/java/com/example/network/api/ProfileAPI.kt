package com.example.network.api

import com.example.data.Profile
import com.example.network.ApiService
import com.example.network.api.interfaceapi.IProfileAPI
import javax.inject.Inject

class ProfileAPI @Inject constructor(private val api: ApiService) : IProfileAPI {
    override suspend fun getAllProfile(): List<Profile> {
        return api.getAllProfile()
    }
}