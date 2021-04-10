package com.example.ceria.data.local

import androidx.lifecycle.LiveData
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.data.local.room.MainDao

class LocalDataSource(private val mainDao: MainDao) {
    fun getUsers(): LiveData<List<HomeEntity>> = mainDao.getUsers()

    fun insertUsers(users: List<HomeEntity>) {
        mainDao.insertUsers(users)
    }
}