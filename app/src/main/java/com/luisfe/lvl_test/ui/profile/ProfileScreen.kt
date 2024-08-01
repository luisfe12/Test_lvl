package com.luisfe.lvl_test.ui.profile

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.luisfe.lvl_test.ui.components.DialogLoading
import com.luisfe.lvl_test.ui.components.TopAppBarComponent
import com.luisfe.lvl_test.ui.newitem.NewProjectViewModel
import com.luisfe.lvl_test.ui.newitem.StateCreateProjectScreen
import com.luisfe.lvl_test.ui.stateclase.StateCreateData
import com.luisfe.lvl_test.ui.theme.BackgroundScreens

@Composable
fun ProfieleScreen(
    navController: NavHostController,
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    val name by profileViewModel.name.collectAsStateWithLifecycle()
    val lastName by profileViewModel.lastName.collectAsStateWithLifecycle()
    val nameEnterprice by profileViewModel.nameEnterprice.collectAsStateWithLifecycle()
    val chargeEnterprice by profileViewModel.chargeEnterprice.collectAsStateWithLifecycle()
    val phone by profileViewModel.phone.collectAsStateWithLifecycle()
    val email by profileViewModel.email.collectAsStateWithLifecycle()

    val stateBtn by profileViewModel.buttonSaveState.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = "Mi Perfil",
                navigateBack = {
                    navController.popBackStack()
                }
            )
        },
        containerColor = BackgroundScreens
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .padding(innerPadding),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween
        ) {


            Image(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Black,
                        shape = CircleShape
                    ).clickable {

                    },
            )

            TextFieldNameProfile(name = name) {
                profileViewModel.changeDataUserTextField(
                    name = it,
                    lastName = lastName,
                    nameE = nameEnterprice,
                    chargeE =  chargeEnterprice,
                    phone = phone,
                    email = email
                )
            }

            TextFieldLastNameProfile(name = lastName) {
                profileViewModel.changeDataUserTextField(
                    name = name,
                    lastName = it,
                    nameE = nameEnterprice,
                    chargeE =  chargeEnterprice,
                    phone = phone,
                    email = email
                )
            }
            TextFieldNameEnterpriceProfile(nameE = nameEnterprice) {
                profileViewModel.changeDataUserTextField(
                    name = name,
                    lastName = lastName,
                    nameE = it,
                    chargeE =  chargeEnterprice,
                    phone = phone,
                    email = email
                )
            }

            TextFieldChargeEnterpriceProfile(chargeE = chargeEnterprice) {
                profileViewModel.changeDataUserTextField(
                    name = name,
                    lastName = lastName,
                    nameE = nameEnterprice,
                    chargeE =  it,
                    phone = phone,
                    email = email
                )
            }
            TextFieldPhoneProfile(phone = phone) {
                profileViewModel.changeDataUserTextField(
                    name = name,
                    lastName = lastName,
                    nameE = nameEnterprice,
                    chargeE =  chargeEnterprice,
                    phone = it,
                    email = email
                )
            }

            TextFieldEmailProfile(email = email) {
                profileViewModel.changeDataUserTextField(
                    name = name,
                    lastName = lastName,
                    nameE = nameEnterprice,
                    chargeE =  chargeEnterprice,
                    phone = phone,
                    email = it
                )
            }


            ButtonSaveUpdateUser(
                stateBtn = stateBtn
            ) {

            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        StateUpdateProfileScreen(
            profileViewModel = profileViewModel,
            goToBack = { navController.popBackStack() }
        ) {
            profileViewModel.setNullStateCreate()
        }
    }
}

@Composable
fun StateUpdateProfileScreen(
    profileViewModel: ProfileViewModel,
    goToBack: () -> Unit,
    setNullState: () -> Unit
) {

    val context = LocalContext.current
    when (val stateNp = profileViewModel.stateCeate) {
        StateCreateData.Loading -> {
            DialogLoading(message = "Actualizando perfil")
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
