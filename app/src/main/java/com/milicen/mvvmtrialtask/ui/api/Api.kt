package com.milicen.mvvmtrialtask.ui.api

import com.milicen.mvvmtrialtask.ui.data.Form
import com.milicen.mvvmtrialtask.ui.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface Api {
    @POST("auth/login")
    suspend fun login(@Body form: Form): Response<User>
}