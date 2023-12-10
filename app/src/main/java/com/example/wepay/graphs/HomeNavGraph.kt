package com.example.wepay.graphs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.wepay.BottomBarScreen
import com.example.wepay.screens.AddExpenseScreen
import com.example.wepay.screens.AddGroupScreen
import com.example.wepay.screens.HomeTabScreen
import com.example.wepay.screens.PaymentsTabScreen
import com.example.wepay.screens.ScreenContent

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            HomeTabScreen(
                onAddExpenseClicked = {
                    navController.navigate(AddExpenseScreen.AddExpense.route)
                },
                onAddGroupClicked = {
                    navController.navigate(AddGroupScreen.AddGroup.route)
                }
            )
            /*ScreenContent(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )*/
        }
        composable(route = BottomBarScreen.Payments.route) {
            PaymentsTabScreen(
                onAddExpenseClicked = {
                    navController.navigate(AddExpenseScreen.AddExpense.route)
                },
                onAddGroupClicked = {
                    navController.navigate(AddGroupScreen.AddGroup.route)
                }
            )
            /*ScreenContent(
                name = BottomBarScreen.Home.route,
                onClick = {
                    navController.navigate(Graph.DETAILS)
                }
            )*/
        }
        composable(route = BottomBarScreen.People.route) {
            ScreenContent(
                name = BottomBarScreen.People.route,
                onClick = { }
            )
        }
        addExpenseNavGraph(navController = navController)
        addGroupNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.addExpenseNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADDEXPENSE,
        startDestination = AddExpenseScreen.AddExpense.route
    ) {
        composable(route = AddExpenseScreen.AddExpense.route) {
            AddExpenseScreen(
                onAddClick = {
                    navController.popBackStack()
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
            /*ScreenContent(name = AddExpenseScreen.AddExpense.route) {
                navController.navigate(AddExpenseScreen.Overview.route)
            }*/
        }
        /*composable(route = AddExpenseScreen.Overview.route) {
            ScreenContent(name = AddExpenseScreen.Overview.route) {
                navController.popBackStack(
                    route = AddExpenseScreen.Information.route,
                    inclusive = false
                )
            }
        }*/
    }
}

sealed class AddExpenseScreen(val route: String) {
    object AddExpense : AddExpenseScreen(route = "addExpense")
    //object Overview : DetailsScreen(route = "OVERVIEW")
}



fun NavGraphBuilder.addGroupNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ADDGROUP,
        startDestination = AddGroupScreen.AddGroup.route
    ) {
        composable(route = AddGroupScreen.AddGroup.route) {
            AddGroupScreen(
                onAddGroupClick = {
                    navController.popBackStack()
                    navController.popBackStack()
                    navController.navigate(Graph.HOME)
                }
            )
            /*ScreenContent(name = AddExpenseScreen.AddExpense.route) {
                navController.navigate(AddExpenseScreen.Overview.route)
            }*/
        }
        /*composable(route = AddExpenseScreen.Overview.route) {
            ScreenContent(name = AddExpenseScreen.Overview.route) {
                navController.popBackStack(
                    route = AddExpenseScreen.Information.route,
                    inclusive = false
                )
            }
        }*/
    }
}

sealed class AddGroupScreen(val route: String) {
    object AddGroup : AddGroupScreen(route = "addGroup")
    //object Overview : DetailsScreen(route = "OVERVIEW")
}
