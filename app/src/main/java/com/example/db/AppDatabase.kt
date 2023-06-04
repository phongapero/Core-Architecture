package com.example.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.db.converter.StringConverters
import com.example.db.dao.GlucoseDAO
import com.example.db.dao.ProfileDao
import com.example.db.entity.GlucoseEntity
import com.example.db.entity.ProfileEntity

@TypeConverters(StringConverters::class)
@Database(entities = [ProfileEntity::class, GlucoseEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun profileDao(): ProfileDao

    abstract fun glucoseDAO(): GlucoseDAO
}