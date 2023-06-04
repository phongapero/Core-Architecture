package com.example.db.datasource

import com.example.db.dao.ProfileDao
import com.example.db.datasource.interfacedatasource.IProfileDataSource
import com.example.db.entity.ProfileEntity
import javax.inject.Inject

class ProfileDataSource
@Inject constructor(private val profileDao: ProfileDao) : IProfileDataSource {
    override suspend fun getProfileByID(id: String): ProfileEntity {
        return profileDao.getProfileByID(id)
    }
}