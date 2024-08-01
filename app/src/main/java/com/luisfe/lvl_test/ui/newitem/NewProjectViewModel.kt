package com.luisfe.lvl_test.ui.newitem

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
class NewProjectViewModel @Inject constructor(

) : ViewModel() {

    private val _nameProject = MutableStateFlow<String>("")
    private val _descriptionProject = MutableStateFlow<String>("")
    private val _stateProject = MutableStateFlow<String>("")
    private val _startDateProject = MutableStateFlow<String>("")
    private val _endDateProject = MutableStateFlow<String>("")
    val name:StateFlow<String> = _nameProject.asStateFlow()
    val descriptionProject:StateFlow<String> = _descriptionProject.asStateFlow()
    val stateProject:StateFlow<String> = _stateProject.asStateFlow()
    val startDateProject:StateFlow<String> = _startDateProject.asStateFlow()
    val endDateProject:StateFlow<String> = _endDateProject.asStateFlow()


    var stateCeate by mutableStateOf<StateCreateData?>(null)

    fun setNullStateCreate(){
        stateCeate = null
    }

    fun changeTextFieldNewProject(
        name: String,
        description: String,
        state:String,
        startDate:String,
        endDate:String
    ) {
        _nameProject.value = name
        _descriptionProject.value = description
        _stateProject.value = state
        _descriptionProject.value = description
        _stateProject.value = startDate
        _endDateProject.value = endDate
    }


    fun createProject(){
        stateCeate = StateCreateData.Loading
        viewModelScope.launch {
            try {
                delay(3000)
                stateCeate = StateCreateData.Success(
                    state = true,
                    message = "creacion exitosa",
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