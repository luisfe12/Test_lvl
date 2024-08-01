package com.luisfe.lvl_test.ui.profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luisfe.lvl_test.ui.stateclase.StateCreateData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ProfileViewModel @Inject constructor():ViewModel() {

    private val _name = MutableStateFlow<String>("")
    private val _lastName = MutableStateFlow<String>("")
    private val _nameEnterprice = MutableStateFlow<String>("")
    private val _chargeEnterprice = MutableStateFlow<String>("")
    private val _phone = MutableStateFlow<String>("")
    private val _email = MutableStateFlow<String>("")
    private val _buttonSaveState = MutableStateFlow<Boolean>(false)


    val name:StateFlow<String> =_name.asStateFlow()
    val lastName:StateFlow<String> =_lastName.asStateFlow()
    val nameEnterprice:StateFlow<String> = _nameEnterprice.asStateFlow()
    val chargeEnterprice:StateFlow<String> = _chargeEnterprice.asStateFlow()
    val phone:StateFlow<String> = _phone.asStateFlow()
    val email:StateFlow<String> = _email.asStateFlow()
    val buttonSaveState:StateFlow<Boolean> = _buttonSaveState.asStateFlow()

    var stateCeate by mutableStateOf<StateCreateData?>(null)


    fun setNullStateCreate(){
        stateCeate = null
    }

    fun changeDataUserTextField(
        name:String,
        lastName:String,
        nameE:String,
        chargeE:String,
        phone:String,
        email:String
    ){
        _name.value = name
        _lastName.value = lastName
        _nameEnterprice.value = nameE
        _chargeEnterprice.value = chargeE
        _phone.value = phone
        _email.value = email

        _buttonSaveState.value = changeStateBtnSave(
            name = name,
            lastName =lastName,
            nameE = nameE,
            chargeE = chargeE,
            phone = phone,
            email = email
        )
    }

    private fun changeStateBtnSave(
        name: String,
        lastName: String,
        nameE: String,
        chargeE: String,
        phone: String,
        email: String
    ): Boolean {
        return  if (
            name.isNotEmpty() &&
            lastName.isNotEmpty() &&
            nameE.isNotEmpty() &&
            chargeE.isNotEmpty() &&
            phone.isNotEmpty() &&
            email.isNotEmpty()
        ){
            true
        }else{
            false
        }
    }



    fun createProject(){
        stateCeate = StateCreateData.Loading
        viewModelScope.launch {
            try {
                delay(3000)
                stateCeate = StateCreateData.Success(
                    state = true,
                    message = "Actualizacion exitosa",
                )

            }catch (e:Exception){
                stateCeate = StateCreateData.Success(
                    state = false,
                    message = e.message.toString(),
                )
            }
        }
    }

}