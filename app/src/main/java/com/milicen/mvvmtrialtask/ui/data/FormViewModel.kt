package com.milicen.mvvmtrialtask.ui.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.milicen.mvvmtrialtask.ui.model.User
import com.milicen.mvvmtrialtask.ui.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response

class FormViewModel : ViewModel() {

    private var _data = MutableStateFlow(Form())
    val data: StateFlow<Form> = _data.asStateFlow()

    var confirmPass by mutableStateOf("")

    val repository = Repository()

    var loginResponse: MutableLiveData<Response<User>> = MutableLiveData()

    fun setUsername(username: String) {
        _data.update {
            it.copy(
                username = username
            )
        }
    }

    fun setPassword(password: String) {
        _data.update {
            it.copy(
                password = password
            )
        }
    }

    fun setConfirmPassword(confirmPass: String) {
        this.confirmPass = confirmPass
    }

    fun login() {
        viewModelScope.launch {
            val response = repository.login(_data.value)
            loginResponse.value = response
        }
    }

    fun reset() {
        _data.value = Form()
    }
}