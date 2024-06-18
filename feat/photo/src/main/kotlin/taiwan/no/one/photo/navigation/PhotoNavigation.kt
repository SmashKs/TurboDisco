package taiwan.no.one.photo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.photo.component.PhotoRoute

@Serializable
data object PhotoGraph

@Serializable
private data object PhotoHome

fun NavController.navigateToPhoto(navOptions: NavOptions) = navigate(PhotoGraph, navOptions)

@Composable
fun PhotoNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PhotoHome,
    ) {
        composable<PhotoHome> {
            PhotoRoute()
        }
    }
}
