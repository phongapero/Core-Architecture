package com.example.data.repository

import com.example.db.datasource.interfacedatasource.IProfileDataSource
import com.example.network.api.interfaceapi.IProfileAPI
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    var iProfileDataSource: IProfileDataSource,
    var iProfileAPI: IProfileAPI
) {

}