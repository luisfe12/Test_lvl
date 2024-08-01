package com.luisfe.lvl_test.navigation

sealed class Routes(val routes:String) {
    object Splash:Routes(routes = "splash_screen")
    object Login:Routes(routes = "login_screen")
    object SignUp:Routes(routes = "signup_screen")
    object Home:Routes(routes = "home_screen")
    object Profile:Routes(routes = "profile_screen")
    object NewProject:Routes(routes = "new_project_screen")
    object ProfilePhoto:Routes(routes = "profile_photo_screen")
}