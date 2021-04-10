package com.example.ceria.data

import androidx.lifecycle.LiveData
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.data.uiresponse.Resource

interface DataRepository {
    fun getUsers(query:String): LiveData<Resource<List<HomeEntity>>>
}