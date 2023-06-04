package com.example.data.mapping

import com.example.data.Profile
import com.example.db.entity.ProfileEntity
import kotlin.reflect.full.memberProperties

object MappingData {
    fun ProfileEntity.toProfile() = with(::Profile) {
        val propertiesByName = ProfileEntity::class.memberProperties.associateBy { it.name }
        callBy(parameters.associate { parameter ->
            parameter to when (parameter.name) {
                ProfileEntity::id.name -> name
                ProfileEntity::fullName.name -> fullName
                else -> propertiesByName[parameter.name]?.get(this@toProfile)
            }
        })
    }
}