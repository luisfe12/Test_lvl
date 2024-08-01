package com.luisfe.lvl_test.ui.stateclase

import com.luisfe.lvl_test.data.model.ResponseProductsItem

sealed class StateHomeProducts {
    object Loading : StateHomeProducts()
    data class Succes(
        val state: Boolean,
        val listproducts: List<ResponseProductsItem>,
        val message: String
    ) : StateHomeProducts()
}