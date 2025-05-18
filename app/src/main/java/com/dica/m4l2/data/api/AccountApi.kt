package com.dica.m4l2.data.api

import com.dica.m4l2.data.model.Account
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AccountApi {
    @GET("accounts")
    fun getAccounts(): Call<List<com.dica.m4l2.data.model.Account>>

    @POST("accounts")
    fun createAccount(@Body model: com.dica.m4l2.data.model.Account):Call<Account>

    @DELETE("accounts/{id}")
    fun deleteAccount(
        @Path("id") id:String
    ):Call<Unit>

    @PUT("accounts/{id}")
    fun updateAccount(
        @Path("id") id:String,
        @Body account: Account
    ):Call<Account>
}