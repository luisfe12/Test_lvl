package com.luisfe.lvl_test.ui.splash

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.luisfe.lvl_test.R
import com.luisfe.lvl_test.navigation.Routes
import com.luisfe.lvl_test.ui.stateclase.SplashState

@Composable
fun SplashScreen(
    navtController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel()
    ) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.splashimage),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
        )

        StateSplashScreen(
            goToLogin = {
                navtController.navigate(it){
                    popUpTo( route = Routes.Splash.routes){
                        inclusive = true
                    }
                }
            },
            goToHome = {
                navtController.navigate(it){
                    popUpTo( route = Routes.Splash.routes){
                        inclusive = true
                    }
                }
            },
            setNullState = { splashViewModel.setNull() },
            splashViewModel = splashViewModel
        )
    }
}

@Composable
fun StateSplashScreen(
    goToLogin:(String) ->Unit,
    goToHome:(String) ->Unit,
    setNullState:() -> Unit,
    splashViewModel: SplashViewModel
){
    val context = LocalContext.current
    when(val splashState = splashViewModel.splashState){
        is SplashState.SuccesNavigation -> {
            if (splashState.state){
                Toast.makeText(context, splashState.message, Toast.LENGTH_SHORT).show()
                goToHome(splashState.route)
                setNullState()
            }else{
                Toast.makeText(context, splashState.message, Toast.LENGTH_SHORT).show()
                goToLogin(splashState.route)
                setNullState()
            }
        }
        else -> {

        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun PreviewSplashScreen(){
//    SplashScreen()
//}