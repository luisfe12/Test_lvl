package com.luisfe.lvl_test.domain

import com.luisfe.lvl_test.data.model.ResponseProductsItem
import com.luisfe.lvl_test.data.repository.HomeRepository
import javax.inject.Inject

class ProductsUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {

    suspend operator fun invoke(): List<ResponseProductsItem> {
        val response = homeRepository.getAllProducts()
        return response.body() ?: emptyList()
    }
}