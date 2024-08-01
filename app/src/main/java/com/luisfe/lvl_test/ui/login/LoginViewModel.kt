package com.luisfe.lvl_test.ui.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisfe.lvl_test.data.repository.AuthRepository
import com.luisfe.lvl_test.ui.stateclase.FirebaseAuthState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {
    private val _email = MutableStateFlow<String>("")
    private val _password = MutableStateFlow<String>("")
    val email: StateFlow<String> = _email.asStateFlow()
    val password: StateFlow<String> = _password.asStateFlow()

    var firebaseAuthState by mutableStateOf<FirebaseAuthState?>(null)


    fun changeTextFieldLogin(
        email: String,
        password: String
    ) {
        _email.value = email
        _password.value = password
    }


    fun setNullStateLogin(){
        firebaseAuthState = null
    }


    fun loginUser() {
        firebaseAuthState = FirebaseAuthState.IsLoading
        viewModelScope.launch {
            try {
                val response = withContext(Dispatchers.IO) {
                    authRepository.login(
                        email = _email.value,
                        psswd = _password.value
                    )
                }

                if (response != null){
                    firebaseAuthState = FirebaseAuthState.Success(
                        state = true,
                        message = "Login exitoso"
                    )
                }else{
                    firebaseAuthState = FirebaseAuthState.Success(
                        state = false,
                        message = "Error en el login"
                    )
                }
            } catch (e: Exception) {
                firebaseAuthState = FirebaseAuthState.Success(
                    state = false,
                    message = e.message.toString()
                )
            }
        }
    }
}