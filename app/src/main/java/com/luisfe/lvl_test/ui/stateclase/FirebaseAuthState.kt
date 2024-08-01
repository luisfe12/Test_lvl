package com.luisfe.lvl_test.ui.stateclase


sealed class FirebaseAuthState {
    object IsLoading : FirebaseAuthState()
    data class Success(val state:Boolean, val message:String) : FirebaseAuthState()
}