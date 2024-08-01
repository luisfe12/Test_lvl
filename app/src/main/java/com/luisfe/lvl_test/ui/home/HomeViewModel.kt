package com.luisfe.lvl_test.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisfe.lvl_test.domain.ProductsUseCase
import com.luisfe.lvl_test.ui.stateclase.StateHomeProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val productsUseCase: ProductsUseCase
):ViewModel() {

    //todo campo para escribir en la barra de busqueda
    private val _textSearBar = MutableStateFlow<String>("")
    val textSearBar:StateFlow<String> = _textSearBar.asStateFlow()

    //todo campos para buscar usando el dialog
    private val _codeProject = MutableStateFlow<String>("")
    private val _name = MutableStateFlow<String>("")
    private val _state = MutableStateFlow<String>("")
    private val _category = MutableStateFlow<String>("")
    private val _iconProject = MutableStateFlow<String>("")
    private val _startDate = MutableStateFlow<String>("")
    private val _endDate = MutableStateFlow<String>("")

    val codeProject:StateFlow<String> = _codeProject.asStateFlow()
    val name:StateFlow<String> = _name.asStateFlow()
    val state:StateFlow<String> = _state.asStateFlow()
    val category:StateFlow<String> = _category.asStateFlow()
    val iconPoject:StateFlow<String> = _iconProject.asStateFlow()
    val startDate:StateFlow<String> = _startDate.asStateFlow()
    val endDate:StateFlow<String> = _endDate.asStateFlow()

    var stateProducts by mutableStateOf<StateHomeProducts?>(
        null
    )

    init {
        getAllProducts()
    }

    fun changeTextSearBar(newValue:String) {
        _textSearBar.value = newValue
    }

    fun changeTextFromSearchDialog(
        codeProject:String,
        name:String,
        state:String,
        category:String,
        iconPoject:String,
        startDate:String,
        endDate:String
    ) {
        _codeProject.value = codeProject
        _name.value = name
        _state.value = state
        _category.value = category
        _iconProject.value = iconPoject
        _startDate.value = startDate
        _endDate.value = endDate
    }

    fun clearAllTextFieldDialog(){
        _codeProject.value = ""
        _name.value = ""
        _state.value = ""
        _category.value = ""
        _iconProject.value = ""
        _startDate.value = ""
        _endDate.value = ""
    }


    fun getAllProducts (){
        stateProducts = StateHomeProducts.Loading
        viewModelScope.launch {
            try {
                val listP = withContext(Dispatchers.IO){
                    productsUseCase()
                }

                if(listP.isNotEmpty()){
                    stateProducts = StateHomeProducts.Succes(
                        state = true,
                        listproducts = listP,
                        message = "conexion exitosa"
                    )
                }else{
                    stateProducts = StateHomeProducts.Succes(
                        state = false,
                        listproducts = emptyList(),
                        message = "conexion exitosa"
                    )
                }
            }catch (e:Exception){
                stateProducts = StateHomeProducts.Succes(
                    state = false,
                    listproducts = emptyList(),
                    message = e.message.toString()
                )
            }
        }
    }

}