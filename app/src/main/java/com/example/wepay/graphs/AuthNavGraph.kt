package com.example.wepay.graphs

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.wepay.graphs.Graph
import com.example.wepay.screens.LoginContent
import com.example.wepay.screens.ScreenContent
import com.example.wepay.screens.SkipScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginContent(
                onLoginClick = {
                    /*navController.popBackStack()
                    navController.navigate(Graph.HOME)*/
                },
                onLoginWithGoogleClick = {
                    /*navController.popBackStack()
                    navController.navigate(Graph.HOME)*/
                },
                onSignUpClick = {
                    /*navController.popBackStack()
                    navController.navigate(Graph.HOME)*/
                },
                onSkipClick = {
                    navController.navigate(AuthScreen.Skip.route)
                },

                /*onSignUpClick = {
                    navController.navigate(AuthScreen.SignUp.route)
                },
                onForgotClick = {
                    navController.navigate(AuthScreen.Forgot.route)
                }*/
            )
        }
        composable(route = AuthScreen.Skip.route) {
            SkipScreen(
                onBackClicked = {
                    navController.popBackStack()
                    navController.navigate(AuthScreen.Login.route)
                },
                onNextClicked = {
                    navController.popBackStack()
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                })
        }
        /*composable(route = AuthScreen.SignUp.route) {
            ScreenContent(name = AuthScreen.SignUp.route) {}
        }*/
        /*composable(route = AuthScreen.Forgot.route) {
            ScreenContent(name = AuthScreen.Forgot.route) {}
        }*/
    }
}

sealed class AuthScreen(val route: String) {
    object Login : AuthScreen(route = "login")
    object LoginWithGoogle : AuthScreen(route = "loginWithGoogle")
    object SignUp : AuthScreen(route = "signUp")
    object Skip : AuthScreen(route = "skip")
}