package com.luisfe.lvl_test.ui.signup

import android.widget.Space
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.luisfe.lvl_test.R
import com.luisfe.lvl_test.navigation.Routes
import com.luisfe.lvl_test.ui.components.DialogLoading
import com.luisfe.lvl_test.ui.components.TextFieldPasswordComponent
import com.luisfe.lvl_test.ui.components.TextFieldUserComponent
import com.luisfe.lvl_test.ui.login.ButtonLogin
import com.luisfe.lvl_test.ui.login.CheckBoxRemenber
import com.luisfe.lvl_test.ui.login.RowTextJira
import com.luisfe.lvl_test.ui.login.StateLoginScreen
import com.luisfe.lvl_test.ui.stateclase.FirebaseAuthState
import com.luisfe.lvl_test.ui.theme.GreyJira
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun SignUpScreen(
    navController: NavHostController,
    signUpViewModel: SignUpViewModel = hiltViewModel()
) {

    val email by signUpViewModel.email.collectAsStateWithLifecycle()
    val password by signUpViewModel.password.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Image(
            painter = painterResource(id = R.drawable.splashimage),
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "¡Que esperas Registrate!", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        RowTextJiraSignUp()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldUserComponent(
            email = email,
            onTextCahnge = {
                signUpViewModel.changeTextFieldLogin(
                    email = it,
                    password = password
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPasswordComponent(
            password = password,
            onTextCahnge = {
                signUpViewModel.changeTextFieldLogin(
                    email = email,
                    password = it
                )
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonSignUp(
            onClickSignUp = {
                signUpViewModel.sigUpUser()
            }
        )
        Spacer(modifier = Modifier.weight(2f))

        StateSigUpScreen(
            signUpViewModel = signUpViewModel,
            navigateToHome = {
                navController.navigate(Routes.Home.routes) {
                    popUpTo(Routes.SignUp.routes) {
                        inclusive = true
                    }
                }
            },
            setNullState = {
                signUpViewModel.setNullStateLogin()
            },
        )
    }
}

@Composable
fun StateSigUpScreen(
    signUpViewModel: SignUpViewModel,
    navigateToHome: () -> Unit,
    setNullState: () -> Unit
) {

    val context = LocalContext.current
    when(val firebaseAuthState = signUpViewModel.firebaseAuthState){
        FirebaseAuthState.IsLoading -> {
            DialogLoading(message = "Registrando usuario")
        }

        is FirebaseAuthState.Success -> {
            if (firebaseAuthState.state){
                Toast.makeText(context, firebaseAuthState.message, Toast.LENGTH_SHORT).show()
                navigateToHome()
                setNullState()
            }else{
                Toast.makeText(context, firebaseAuthState.message, Toast.LENGTH_SHORT).show()
                setNullState()
            }
        }

        else -> {

        }
    }
}
