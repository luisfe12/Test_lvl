package com.luisfe.lvl_test.data.repository

import com.luisfe.lvl_test.data.model.ResponseProductsItem
import retrofit2.Response

interface HomeRepository {

    suspend fun getAllProducts():Response<List<ResponseProductsItem>>
}