package com.example.ceria.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.ceria.data.DataRepository
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.data.uiresponse.Resource

class HomeViewModel(private val dataRepository: DataRepository, private val query: String) : ViewModel() {
    private fun getUsersRepo() = dataRepository.getUsers(query)
    fun getUsers(): LiveData<Resource<List<HomeEntity>>> = getUsersRepo()
}