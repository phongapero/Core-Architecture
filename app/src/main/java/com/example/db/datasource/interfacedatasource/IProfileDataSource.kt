package com.example.db.datasource.interfacedatasource

import com.example.db.entity.ProfileEntity

interface IProfileDataSource {

    suspend fun getProfileByID(id: String): ProfileEntity
}