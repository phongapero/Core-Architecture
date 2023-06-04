package com.example.di.module

import android.content.Context
import androidx.room.Room
import com.example.db.AppDatabase
import com.example.db.dao.GlucoseDAO
import com.example.db.dao.ProfileDao
import com.example.db.datasource.GlucoseDataSource
import com.example.db.datasource.ProfileDataSource
import com.example.db.datasource.interfacedatasource.IGlucoseDataSource
import com.example.db.datasource.interfacedatasource.IProfileDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    companion object {
        const val DATABASE_NAME = "weather_db"
    }

    @Singleton
    @Provides
    fun getDatabase(context: Context): AppDatabase {
        val database = Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)

            // Todo: If want to add default value for any table
//            .createFromAsset("cities.db")
//            .addCallback(object : RoomDatabase.Callback() {
//                override fun onCreate(db: SupportSQLiteDatabase) {
//                    super.onCreate(db)
//                    db.execSQL("INSERT INTO cities_fts(cities_fts) VALUES ('rebuild')")
//                }
//            })
            .fallbackToDestructiveMigration()
            .build()
        return database
    }


    @Singleton
    @Provides
    fun provideProfileDao(db: AppDatabase): ProfileDao {
        return db.profileDao()
    }

    @Singleton
    @Provides
    fun provideProfileDataSource(profileDao: ProfileDao): IProfileDataSource {
        return ProfileDataSource(profileDao)
    }

    @Singleton
    @Provides
    fun provideGlucoseDAO(db: AppDatabase): GlucoseDAO {
        return db.glucoseDAO()
    }

    @Singleton
    @Provides
    fun provideGlucoseDataSource(glucoseDAO: GlucoseDAO): IGlucoseDataSource {
        return GlucoseDataSource(glucoseDAO)
    }
}