package com.example.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.Profile
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "profile")
data class ProfileEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long?,

    @ColumnInfo(name = "name")
    var fullName: String?,

    ) : Parcelable {
    companion object {
        fun fromProfileAPI(profile: Profile): ProfileEntity {
            return ProfileEntity(
                profile.id,
                profile.fullName
            )
        }
    }
}