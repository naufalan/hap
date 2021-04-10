package com.example.ceria.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.ceria.data.local.entity.HomeEntity


@Dao
interface MainDao {
    @Query("SELECT * FROM usersentity")
    //@Query("SELECT phone_number FROM usersentity")
    fun getUsers(): LiveData<List<HomeEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<HomeEntity>)
}