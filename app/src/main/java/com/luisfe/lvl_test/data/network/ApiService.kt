package com.luisfe.lvl_test.data.network

import com.luisfe.lvl_test.data.model.ResponseProductsItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getProducts():Response<List<ResponseProductsItem>>
}