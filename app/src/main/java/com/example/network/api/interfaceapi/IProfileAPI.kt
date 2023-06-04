package com.example.network.api.interfaceapi

import com.example.data.Profile

interface IProfileAPI {

    suspend fun getAllProfile(): List<Profile>
}