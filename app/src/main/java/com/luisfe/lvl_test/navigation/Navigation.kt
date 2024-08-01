package com.luisfe.lvl_test.navigation

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.luisfe.lvl_test.ui.home.HomeScreen
import com.luisfe.lvl_test.ui.login.LoginScreen
import com.luisfe.lvl_test.ui.newitem.CreateNewProjectScreen
import com.luisfe.lvl_test.ui.peofilephoto.ProfilePhotoScreen
import com.luisfe.lvl_test.ui.profile.ProfieleScreen
import com.luisfe.lvl_test.ui.signup.SignUpScreen
import com.luisfe.lvl_test.ui.splash.SplashScreen
import com.luisfe.lvl_test.ui.theme.BackgroundScreens

@Composable
fun ContentWrapper(
    navController: NavHostController,
    activity: Activity
) {
    NavHost(
        navController = navController, startDestination = Routes.Splash.routes,
    ) {
        
        composable(route = Routes.Splash.routes) {
            SplashScreen(navtController = navController)
        }

        composable(route = Routes.Login.routes){
            LoginScreen(navController = navController)
        }

        composable(route = Routes.SignUp.routes){
            SignUpScreen(navController = navController)
        }

        composable(route = Routes.Home.routes){
            HomeScreen(navController = navController)
        }

        composable(route = Routes.Profile.routes){
            ProfieleScreen(navController = navController)
        }

        composable(route = Routes.NewProject.routes){
            CreateNewProjectScreen(navController = navController)
        }

        composable(route = Routes.ProfilePhoto.routes){
            ProfilePhotoScreen(navController = navController, activity = activity)
        }
    }
}