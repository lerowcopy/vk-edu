package com.example.vkedu.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkedu.ui.AppListScreen
import com.example.vkedu.ui.appdetails.AppDetailsScreen

object Routes {
    const val APP_LIST = "app_list"
    const val APP_DETAILS = "app_details"
}

@Composable
fun AppNavGraph(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Routes.APP_LIST,
    ) {
        composable(Routes.APP_LIST) {
            AppListScreen(
                onAppClick = {
                    navController.navigate(Routes.APP_DETAILS) {
                        launchSingleTop = true
                    }
                },
            )
        }

        composable(Routes.APP_DETAILS) {
            AppDetailsScreen(
                onBackClick = { navController.popBackStack() },
                onShowcaseAppClick = {
                    val returned = navController.popBackStack(Routes.APP_LIST, inclusive = false)
                    if (!returned) {
                        navController.navigate(Routes.APP_LIST)
                    }
                },
            )
        }
    }
}
