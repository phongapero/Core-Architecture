package com.example.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.db.entity.ProfileEntity

@Dao
interface ProfileDao {
    @Query("SELECT * FROM profile WHERE id =:id")
    suspend fun getProfileByID(id: String): ProfileEntity

}