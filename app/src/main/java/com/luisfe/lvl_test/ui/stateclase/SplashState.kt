package com.luisfe.lvl_test.ui.stateclase

sealed class SplashState {
    data class SuccesNavigation(
        val state: Boolean,
        val route: String,
        val message: String
    ) : SplashState()
}