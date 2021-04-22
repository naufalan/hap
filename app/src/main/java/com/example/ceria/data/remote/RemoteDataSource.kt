package com.example.ceria.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ceria.data.remote.response.Item
import com.example.ceria.data.remote.response.User
import com.example.ceria.network.RetrofitClient
import com.example.ceria.network.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import timber.log.Timber

class RemoteDataSource {
    private val retrofit: Retrofit = RetrofitClient.instance
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val jsonApi: Service = retrofit.create(Service::class.java)

    fun getUsers(query: String): LiveData<ApiResponse<List<User>>> {
        val result = MutableLiveData<ApiResponse<List<User>>>()
        compositeDisposable.add(
            jsonApi.getUsers(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    data.let {
                        result.value = ApiResponse.success(it.users)
                        Timber.e(it.users.toString())
                    }
                }, {
                    it.message?.let { it1 ->
                        val list = ArrayList<Item>()
                        result.value = ApiResponse.error(it1, list)
                        Timber.e(it1)
                    }
                })
        )
        return result
    }
}