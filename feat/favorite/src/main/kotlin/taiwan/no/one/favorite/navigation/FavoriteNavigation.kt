package taiwan.no.one.favorite.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import taiwan.no.one.favorite.component.FavoriteRoute

@Serializable
data object FavoriteGraph

@Serializable
private data object FavoriteRoute

fun NavController.navigateToFavorite(navOptions: NavOptions) = navigate(FavoriteGraph, navOptions)

@Composable
fun FavoriteNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = FavoriteRoute,
    ) {
        composable<FavoriteRoute> {
            FavoriteRoute(modifier = Modifier)
        }
    }
}
