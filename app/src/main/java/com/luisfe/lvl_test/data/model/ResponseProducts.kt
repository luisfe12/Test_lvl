package com.luisfe.lvl_test.data.model


data class ResponseProductsItem(
    val category: Category,
    val creationAt: String,
    val description: String,
    val id: Int,
    val images: List<String>,
    val price: Int,
    val title: String,
    val updatedAt: String
)

data class Category(
    val creationAt: String,
    val id: Int,
    val image: String,
    val name: String,
    val updatedAt: String
)