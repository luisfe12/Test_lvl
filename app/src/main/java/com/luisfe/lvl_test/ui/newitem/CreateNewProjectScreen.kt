package com.luisfe.lvl_test.ui.newitem

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.luisfe.lvl_test.ui.components.DialogLoading
import com.luisfe.lvl_test.ui.components.TopAppBarComponent
import com.luisfe.lvl_test.ui.stateclase.StateCreateData
import com.luisfe.lvl_test.ui.theme.BackgroundScreens
import com.luisfe.lvl_test.ui.theme.GreyJira

@Composable
fun CreateNewProjectScreen(
    navController: NavController,
    newProjectViewModel: NewProjectViewModel = hiltViewModel()
) {

    val name by newProjectViewModel.name.collectAsStateWithLifecycle()
    val descriptionProject by newProjectViewModel.descriptionProject.collectAsStateWithLifecycle()
    val stateProject by newProjectViewModel.stateProject.collectAsStateWithLifecycle()
    val startDateProject by newProjectViewModel.startDateProject.collectAsStateWithLifecycle()
    val endDateProject by newProjectViewModel.endDateProject.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarComponent(title = "Nuevo Proyecto") {
                navController.popBackStack()
            }
        },
        containerColor = BackgroundScreens
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(20.dp),

            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Icono del proyecto", color = GreyJira)
            RowChangeIconProject()
            TextFieldNameNewPoject(name = name) {
                newProjectViewModel.changeTextFieldNewProject(
                    name = it,
                    description = descriptionProject,
                    state = stateProject,
                    startDate = startDateProject,
                    endDate = endDateProject
                )
            }

            TextFieldDescriptionNewPoject(description = descriptionProject) {
                newProjectViewModel.changeTextFieldNewProject(
                    name = name,
                    description = it,
                    state = stateProject,
                    startDate = startDateProject,
                    endDate = endDateProject
                )
            }

            TextFieldStateNewPoject(
                state = stateProject,
                onTextChange = {
                    newProjectViewModel.changeTextFieldNewProject(
                        name = name,
                        description = descriptionProject,
                        state = it,
                        startDate = startDateProject,
                        endDate = endDateProject
                    )
                },
                onIconClick = {

                }
            )

            TextFieldStateStartDatePoject(
                startD = startDateProject,
                onTextChange = {
                    newProjectViewModel.changeTextFieldNewProject(
                        name = name,
                        description = descriptionProject,
                        state = stateProject,
                        startDate = it,
                        endDate = endDateProject
                    )
                },
                onIconClick = {

                }
            )

            TextFieldStateEndDatePoject(
                endD = endDateProject,
                onTextChange = {
                    newProjectViewModel.changeTextFieldNewProject(
                        name = name,
                        description = descriptionProject,
                        state = stateProject,
                        startDate = startDateProject,
                        endDate = it
                    )
                },
                onIconClick = {

                }
            )

            ButtonCreateProject(
                onClickCreate = {
                    newProjectViewModel.createProject()
                }
            )
            
            Spacer(modifier = Modifier.height(20.dp))
        }

        StateCreateProjectScreen(
            newProjectViewModel = newProjectViewModel,
            goToBack = { navController.popBackStack() }
        ) {
            newProjectViewModel.setNullStateCreate()
        }
    }
}


@Composable
fun StateCreateProjectScreen(
    newProjectViewModel: NewProjectViewModel,
    goToBack: () -> Unit,
    setNullState: () -> Unit
) {

    val context = LocalContext.current
    when (val stateNp = newProjectViewModel.stateCeate) {
        StateCreateData.Loading -> {
            DialogLoading(message = "Creando proyecto")
        }

        is StateCreateData.Success -> {
            if (stateNp.state) {
                Toast.makeText(context, stateNp.message, Toast.LENGTH_SHORT).show()
                goToBack()
                setNullState()
            } else {
                Toast.makeText(context, stateNp.message, Toast.LENGTH_SHORT).show()
                setNullState()
            }
        }

        else -> {

        }
    }

}