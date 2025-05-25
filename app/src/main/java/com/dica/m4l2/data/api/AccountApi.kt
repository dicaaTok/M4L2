package com.dica.m4l2.data.api

import com.dica.m4l2.data.model.Account
import com.dica.m4l2.data.model.PatchAccountStatusDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AccountApi {
    //Метод для получения списка
    @GET("accounts")
    fun getAccounts(): Call<List<com.dica.m4l2.data.model.Account>>

    //Метод для создания нового счета
    @POST("accounts")
    fun createAccount(@Body model: com.dica.m4l2.data.model.Account): Call<Account>

    // Метод для удаления счета
    @DELETE("accounts/{id}")
    fun deleteAccount(
        @Path("id") id: String
    ): Call<Unit>

    //Метод для полного обноления
    @PUT("accounts/{id}")
    fun updateAccount(
        @Path("id") id: String,
        @Body account: Account
    ): Call<Account>

    //Метод для частичного обновления
    @PATCH("accounts/{id}")
    fun patchAccountsStatus(
        @Path("id") id: String,
        @Body patchAccountStatusDTO: PatchAccountStatusDTO
    ): Call<Account>

}
