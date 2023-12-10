package com.example.wepay

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Payments : BottomBarScreen(
        route = "payments",
        title = "Payments",
        icon = Icons.Default.ShoppingCart
    )

    object People : BottomBarScreen(
        route = "people",
        title = "People",
        icon = Icons.Default.Person
    )
}