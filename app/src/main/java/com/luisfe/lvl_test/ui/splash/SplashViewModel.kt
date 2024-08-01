package com.luisfe.lvl_test.ui.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisfe.lvl_test.data.repository.AuthRepository
import com.luisfe.lvl_test.navigation.Routes
import com.luisfe.lvl_test.ui.stateclase.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashViewModel @Inject constructor(
    private val authRepository: AuthRepository
):ViewModel() {

    var splashState by mutableStateOf<SplashState?>(null)

    init {
        isUserLogin()
    }

    fun setNull(){
        splashState = null
    }

    fun isUserLogin() {
        viewModelScope.launch {
            try {
                val response = authRepository.isLogin()
                if (response) {
                    splashState = SplashState.SuccesNavigation(
                        state = true,
                        route = Routes.Home.routes,
                        message = "inicio exitos"
                    )
                }else{
                    splashState = SplashState.SuccesNavigation(
                        state = false,
                        route = Routes.Login.routes,
                        message = "no hay sesion inicada"
                    )
                }
            }catch (e: Throwable) {
                splashState = SplashState.SuccesNavigation(
                    state = false,
                    route = "niguna",
                    message = e.message.toString()
                )
            }
        }
    }
}