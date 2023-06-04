package com.example.db.datasource

import com.example.db.dao.GlucoseDAO
import com.example.db.datasource.interfacedatasource.IGlucoseDataSource
import javax.inject.Inject

class GlucoseDataSource @Inject constructor(private val glucoseDAO: GlucoseDAO) :
    IGlucoseDataSource {
    override suspend fun countBloodSugarByProfileID(profileId: Long): Int {
        return glucoseDAO.countBloodSugarByProfileID(profileId)
    }
}