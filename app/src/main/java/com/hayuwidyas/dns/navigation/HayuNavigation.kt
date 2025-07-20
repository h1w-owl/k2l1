package com.hayuwidyas.dns.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hayuwidyas.dns.ui.screens.home.HomeScreen
import com.hayuwidyas.dns.ui.screens.shop.ShopScreen
import com.hayuwidyas.dns.ui.screens.product.ProductDetailScreen
import com.hayuwidyas.dns.ui.screens.cart.CartScreen
import com.hayuwidyas.dns.ui.screens.wishlist.WishlistScreen
import com.hayuwidyas.dns.ui.screens.profile.ProfileScreen
import com.hayuwidyas.dns.ui.screens.onboarding.OnboardingScreen
import com.hayuwidyas.dns.ui.screens.auth.AuthScreen

@Composable
fun HayuNavigation(
    navController: NavHostController,
    startDestination: String = HayuDestinations.ONBOARDING
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(HayuDestinations.ONBOARDING) {
            OnboardingScreen(
                onNavigateToAuth = {
                    navController.navigate(HayuDestinations.AUTH) {
                        popUpTo(HayuDestinations.ONBOARDING) { inclusive = true }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(HayuDestinations.HOME) {
                        popUpTo(HayuDestinations.ONBOARDING) { inclusive = true }
                    }
                }
            )
        }
        
        composable(HayuDestinations.AUTH) {
            AuthScreen(
                onNavigateToHome = {
                    navController.navigate(HayuDestinations.HOME) {
                        popUpTo(HayuDestinations.AUTH) { inclusive = true }
                    }
                }
            )
        }
        
        composable(HayuDestinations.HOME) {
            HomeScreen(
                onNavigateToShop = {
                    navController.navigate(HayuDestinations.SHOP)
                },
                onNavigateToProduct = { productId ->
                    navController.navigate("${HayuDestinations.PRODUCT_DETAIL}/$productId")
                }
            )
        }
        
        composable(HayuDestinations.SHOP) {
            ShopScreen(
                onNavigateToProduct = { productId ->
                    navController.navigate("${HayuDestinations.PRODUCT_DETAIL}/$productId")
                },
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable("${HayuDestinations.PRODUCT_DETAIL}/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            ProductDetailScreen(
                productId = productId,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(HayuDestinations.CART) {
            CartScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
        
        composable(HayuDestinations.WISHLIST) {
            WishlistScreen(
                onNavigateToProduct = { productId ->
                    navController.navigate("${HayuDestinations.PRODUCT_DETAIL}/$productId")
                }
            )
        }
        
        composable(HayuDestinations.PROFILE) {
            ProfileScreen()
        }
    }
}

object HayuDestinations {
    const val ONBOARDING = "onboarding"
    const val AUTH = "auth"
    const val HOME = "home"
    const val SHOP = "shop"
    const val PRODUCT_DETAIL = "product_detail"
    const val CART = "cart"
    const val WISHLIST = "wishlist"
    const val PROFILE = "profile"
}