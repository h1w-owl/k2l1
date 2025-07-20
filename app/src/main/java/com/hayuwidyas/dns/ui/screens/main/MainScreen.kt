package com.hayuwidyas.dns.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hayuwidyas.dns.navigation.HayuDestinations
import com.hayuwidyas.dns.navigation.HayuNavigation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val shouldShowBottomBar by viewModel.shouldShowBottomBar.collectAsStateWithLifecycle()
    val cartItemCount by viewModel.cartItemCount.collectAsStateWithLifecycle()
    
    val mainNavController = rememberNavController()
    val navBackStackEntry by mainNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    Scaffold(
        bottomBar = {
            if (shouldShowBottomBar) {
                NavigationBar {
                    bottomNavigationItems.forEach { item ->
                        NavigationBarItem(
                            icon = { 
                                BadgedBox(
                                    badge = {
                                        if (item.route == HayuDestinations.CART && cartItemCount > 0) {
                                            Badge { Text(cartItemCount.toString()) }
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = item.icon,
                                        contentDescription = item.label
                                    )
                                }
                            },
                            label = { Text(item.label) },
                            selected = currentDestination?.hierarchy?.any { it.route == item.route } == true,
                            onClick = {
                                mainNavController.navigate(item.route) {
                                    popUpTo(mainNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                    }
                }
            }
        }
    ) { innerPadding ->
        HayuNavigation(
            navController = mainNavController,
            startDestination = HayuDestinations.ONBOARDING
        )
    }
    
    // Listen to navigation changes to update bottom bar visibility
    LaunchedEffect(navBackStackEntry) {
        val route = currentDestination?.route
        viewModel.updateBottomBarVisibility(route)
    }
}

data class BottomNavigationItem(
    val route: String,
    val icon: ImageVector,
    val label: String
)

private val bottomNavigationItems = listOf(
    BottomNavigationItem(
        route = HayuDestinations.HOME,
        icon = Icons.Default.Home,
        label = "Home"
    ),
    BottomNavigationItem(
        route = HayuDestinations.SHOP,
        icon = Icons.Default.ShoppingBag,
        label = "Shop"
    ),
    BottomNavigationItem(
        route = HayuDestinations.WISHLIST,
        icon = Icons.Default.Favorite,
        label = "Wishlist"
    ),
    BottomNavigationItem(
        route = HayuDestinations.CART,
        icon = Icons.Default.ShoppingCart,
        label = "Cart"
    ),
    BottomNavigationItem(
        route = HayuDestinations.PROFILE,
        icon = Icons.Default.AccountCircle,
        label = "Account"
    )
)