package com.example.ceria.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "selfentity")
data class ApplyEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id_self")
    var id_self: Char,

    @ColumnInfo(name = "email")
    var email: String?,

    @ColumnInfo(name = "edu")
    var edu: String?,

    @ColumnInfo(name = "marital_status")
    var marital_status: String,

)


