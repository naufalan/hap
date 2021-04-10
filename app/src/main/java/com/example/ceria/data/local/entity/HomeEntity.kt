package com.example.ceria.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigInteger

@Entity(tableName = "usersentity")
data class HomeEntity(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "id")
        var id: String,

        @ColumnInfo(name = "name")
        var name: String?,

        @ColumnInfo(name = "url")
        var url: String?,

        @ColumnInfo(name = "phone_number")
        var phone_number: String,

        @ColumnInfo(name = "pin")
        var pin: String,


)

