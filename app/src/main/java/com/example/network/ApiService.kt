package com.example.network

import com.example.data.Profile
import retrofit2.http.GET

interface ApiService {

    @GET("profile")
    suspend fun getAllProfile(): List<Profile>

}