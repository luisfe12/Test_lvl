package com.luisfe.lvl_test.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.luisfe.lvl_test.ui.stateclase.FirebaseAuthState
import com.luisfe.lvl_test.ui.theme.GreyJira
import com.luisfe.lvl_test.ui.theme.colorJira

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {

    val email by loginViewModel.email.collectAsStateWithLifecycle()
    val password by loginViewModel.password.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.weight(2f))
        Image(
            painter = painterResource(id = R.drawable.splashimage),
            contentDescription = null,
            )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "¡Te damos la bienvenida!", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        RowTextJira()
        Text(
            text = "Hola, inicia sesión para continuar",
            color = GreyJira,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldUserComponent(
            email = email,
            onTextCahnge = {
                loginViewModel.changeTextFieldLogin(
                    email = it,
                    password = password
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextFieldPasswordComponent(
            password = password,
            onTextCahnge = {
                loginViewModel.changeTextFieldLogin(
                    email = email,
                    password = it
                )
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        CheckBoxRemenber()
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Registrarse",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorJira,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navController.navigate(Routes.SignUp.routes)
                }
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonLogin(
            onClickLogin = {
                loginViewModel.loginUser()
            }
        )
        Spacer(modifier = Modifier.weight(2f))

        StateLoginScreen(
            loginViewModel = loginViewModel,
            navigateToHome = {
                navController.navigate(Routes.Home.routes){
                    popUpTo(Routes.Login.routes){
                        inclusive = true
                    }
                }
            },
            setNullState = {
                loginViewModel.setNullStateLogin()
            },
        )
    }
}


@Composable
fun RowTextJira() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "a ", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "JIRA Atllassia",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = colorJira
        )
        Text(text = "!", fontSize = 25.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.weight(1f))
    }
}


@Composable
fun StateLoginScreen(
    loginViewModel: LoginViewModel,
    navigateToHome: () -> Unit,
    setNullState: () -> Unit
) {

    val context = LocalContext.current
    when (val firebaseAuthState = loginViewModel.firebaseAuthState) {
        FirebaseAuthState.IsLoading -> {
            DialogLoading(message = "Iniciando Sesion")
        }

        is FirebaseAuthState.Success -> {
            if (firebaseAuthState.state) {
                Toast.makeText(context, firebaseAuthState.message, Toast.LENGTH_SHORT).show()
                navigateToHome()
                setNullState()
            } else {
                Toast.makeText(context, firebaseAuthState.message, Toast.LENGTH_SHORT).show()
                setNullState()
            }
        }

        else -> {

        }
    }
}


//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewLoginScreen() {
//    LoginScreen()
//}