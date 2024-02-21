package taiwan.no.one.favorite.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import taiwan.no.one.favorite.component.FavoriteRoute

private const val FAVORITE_ROUTE = "favorite_route"

fun NavController.navigateToFavorite(navOptions: NavOptions) = navigate(FAVORITE_ROUTE, navOptions)

fun NavGraphBuilder.favoriteScreen() {
    composable(route = FAVORITE_ROUTE) {
        FavoriteRoute(modifier = Modifier)
    }
}
