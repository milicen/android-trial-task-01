package com.milicen.mvvmtrialtask.ui.repository

import com.milicen.mvvmtrialtask.ui.api.Service
import com.milicen.mvvmtrialtask.ui.data.Form
import com.milicen.mvvmtrialtask.ui.model.User
import retrofit2.Response

class Repository {
    suspend fun login(form: Form): Response<User> {
        return Service.api.login(form)
    }
}