package com.example.ceria.network


import com.example.ceria.data.response.UserResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface Service {

    @FormUrlEncoded
    @Headers("Accept: application/json",
        "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
        "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/auth/login/")
    suspend fun userLogin(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
        "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
        "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/auth/register/")
    suspend fun userRegister(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/user/profile")
    suspend fun userProfile(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>
    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/api/user/profile")
    suspend fun showProfile(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/user/place")
    suspend fun userPlace(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/user/relative")
    suspend fun userRelative(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @POST("/api/user/work")
    suspend fun userWork(@FieldMap params: HashMap<String?, String?>): Response<ResponseBody>

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/user/12321321321")
    fun getUserData()

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/user/profile/2")
    fun getUserProfile()

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/user/place/2")
    fun getUserPlace()

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/user/relative/2")
    fun getUserRelative()

    @FormUrlEncoded
    @Headers("Accept: application/json",
            "key: 2efcbba6-011b-481c-adbc-c137f7d26e49",
            "secret: BfXPRPWrT5aDszvd8CfDbtRohALzPKZu"
    )
    @GET("/user/work/2")
    fun getUserWork()


    //@GET("api/auth")
    //fun getEndPoint(@Query("login") login: String): Call<UserResponse>
    //@GET("${API.PHONE}/${API.PIN}")
    //fun getUsers(@Query("login") login: String): Call<CeriaResponse>
}
/*interface Service {
    @Headers("Content-Type:application/json")
    @GET("api/auth")
    @POST("register")
    fun signup(@Body info: SignUpBody): retrofit2.Call<CeriaResponse>

    @Headers("Content-Type:application/json")
    @POST("users")
    fun getUser(
        @Body info: User
    ): retrofit2.Call<CeriaResponse>
}*/
