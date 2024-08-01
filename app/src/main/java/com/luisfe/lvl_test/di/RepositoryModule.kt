package com.luisfe.lvl_test.di

import com.google.firebase.auth.FirebaseAuth
import com.luisfe.lvl_test.data.network.ApiService
import com.luisfe.lvl_test.data.repository.AuthRepository
import com.luisfe.lvl_test.data.repository.AuthRepositoryImpl
import com.luisfe.lvl_test.data.repository.HomeRepository
import com.luisfe.lvl_test.data.repository.HomeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providesAuthRepository(firebaseAuth: FirebaseAuth): AuthRepository =
        AuthRepositoryImpl(firebaseAuth)

    @Singleton
    @Provides
    fun provideHomeRepository(apiService: ApiService):HomeRepository =
        HomeRepositoryImpl(apiService)
}