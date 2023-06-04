package com.example.data.repository

import com.example.db.datasource.interfacedatasource.IGlucoseDataSource
import javax.inject.Inject

class GlucoseRepository @Inject constructor(
    var iGlucoseDataSource: IGlucoseDataSource
) {
    suspend fun countBloodSugarByProfileID(profileId: Long): Int {
        return iGlucoseDataSource.countBloodSugarByProfileID(profileId)
    }
}