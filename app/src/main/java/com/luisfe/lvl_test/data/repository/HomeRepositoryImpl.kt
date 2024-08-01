package com.luisfe.lvl_test.data.repository

import com.luisfe.lvl_test.data.model.ResponseProductsItem
import com.luisfe.lvl_test.data.network.ApiService
import retrofit2.Response
import javax.inject.Inject


class HomeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,

):HomeRepository {
    override suspend fun getAllProducts(): Response<List<ResponseProductsItem>> {
        return apiService.getProducts()
    }

}