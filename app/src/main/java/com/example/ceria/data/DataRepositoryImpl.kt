package com.example.ceria.data

import androidx.lifecycle.LiveData
import com.example.ceria.data.local.LocalDataSource
import com.example.ceria.data.local.entity.HomeEntity
import com.example.ceria.data.remote.ApiResponse
import com.example.ceria.data.remote.RemoteDataSource
import com.example.ceria.data.remote.response.Item
import com.example.ceria.data.uiresponse.Resource
import com.example.ceria.util.AppExecutors

class DataRepositoryImpl(
        private val remoteDataSource: RemoteDataSource,
        private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : DataRepository {
    override fun getUsers(query: String): LiveData<Resource<List<HomeEntity>>> {
        return object : NetworkBoundResource<List<HomeEntity>, List<Item>>(appExecutors) {
            public override fun loadFromDB(): LiveData<List<HomeEntity>> {
                return localDataSource.getUsers()
            }

            override fun shouldFetch(data: List<HomeEntity>?): Boolean =
                    data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Item>>> =
                    remoteDataSource.getUsers(query)

            public override fun saveCallResult(data: List<Item>) {
                val users = ArrayList<HomeEntity>()
                for (each in data) {
                    val user = HomeEntity(
                            each.id.toString(),
                            each.login,
                            each.starred_url,
                            each.phone_number.toString(),
                            each.pin.toString()
                    )
                    users.add(user)
                }
                localDataSource.insertUsers(users)
            }
        }.asLiveData()
    }
}