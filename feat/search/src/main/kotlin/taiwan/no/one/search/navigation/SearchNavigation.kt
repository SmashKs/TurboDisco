package taiwan.no.one.search.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import taiwan.no.one.search.SearchRoute

private const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch() = navigate(SEARCH_ROUTE)

fun NavGraphBuilder.searchScreen() {
    composable(
        route = SEARCH_ROUTE,
    ) {
        SearchRoute(modifier = Modifier)
    }
}
