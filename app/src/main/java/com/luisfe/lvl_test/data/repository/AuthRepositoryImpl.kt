package com.luisfe.lvl_test.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class AuthRepositoryImpl@Inject constructor(
    private val firebaseAuth: FirebaseAuth
):AuthRepository {
    override suspend fun login(email: String, psswd: String): FirebaseUser? {
        return firebaseAuth.signInWithEmailAndPassword(email, psswd).await().user
    }

    override suspend fun signUp(email: String, psswd: String): FirebaseUser? {
        return  suspendCancellableCoroutine { cancelableCorutine ->
            firebaseAuth.createUserWithEmailAndPassword(email, psswd).addOnSuccessListener {
                val user = it.user
                cancelableCorutine.resume(user)
            }.addOnFailureListener {
                cancelableCorutine.resumeWithException(it)
            }
        }
    }

    override fun isLogin(): Boolean {
        return getCurrentUser() != null
    }

    override suspend fun updateEmail(email: String) {


//        return suspendCancellableCoroutine { cancelableCorutine ->
//            firebaseAuth.updateCurrentUser(email,"")
//        }
    }

    private fun getCurrentUser():FirebaseUser? = firebaseAuth.currentUser
}