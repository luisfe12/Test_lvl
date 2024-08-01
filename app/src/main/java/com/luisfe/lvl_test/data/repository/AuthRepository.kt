package com.luisfe.lvl_test.data.repository

import com.google.firebase.auth.FirebaseUser

interface AuthRepository {

    suspend fun login(email:String, psswd:String): FirebaseUser?
    suspend fun signUp(email:String, psswd:String): FirebaseUser?
    fun isLogin():Boolean
    suspend fun updateEmail(email: String)
}