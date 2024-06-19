package taiwan.no.one.profile.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.profile.component.ProfileRoute

@Serializable
data object ProfileGraph

@Serializable
private data object ProfileRoute

fun NavController.navigateToProfile(navOptions: NavOptions) = navigate(ProfileGraph, navOptions)

@Composable
fun ProfileNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ProfileRoute,
    ) {
        composable<ProfileRoute> {
            ProfileRoute()
        }
    }
}
