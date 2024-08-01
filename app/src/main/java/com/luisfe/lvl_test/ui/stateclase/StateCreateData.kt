package com.luisfe.lvl_test.ui.stateclase

sealed class StateCreateData {
    object Loading : StateCreateData()
    data class Success(val state: Boolean, val message: String) : StateCreateData()
}