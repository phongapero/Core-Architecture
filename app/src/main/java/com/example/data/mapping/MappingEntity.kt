package com.example.data.mapping

import com.example.data.Profile
import com.example.db.entity.ProfileEntity
import kotlin.reflect.full.memberProperties

object MappingEntity {
    fun Profile.toProfileEntity() = with(::ProfileEntity) {
        val propertiesByName = Profile::class.memberProperties.associateBy { it.name }
        callBy(parameters.associate { parameter ->
            parameter to when (parameter.name) {
                Profile::id.name -> name
                Profile::fullName.name -> fullName
                else -> propertiesByName[parameter.name]?.get(this@toProfileEntity)
            }
        })
    }
}