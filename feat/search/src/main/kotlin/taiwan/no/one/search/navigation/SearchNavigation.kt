package taiwan.no.one.search.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import taiwan.no.one.search.component.SearchRoute

const val SEARCH_GRAPH_ROUTE_PATTERN = "search_graph"
private const val SEARCH_ROUTE = "search_route"

fun NavController.navigateToSearch(navOptions: NavOptions) = navigate(SEARCH_GRAPH_ROUTE_PATTERN, navOptions)

fun NavGraphBuilder.searchGraph() {
    navigation(
        route = SEARCH_GRAPH_ROUTE_PATTERN,
        startDestination = SEARCH_ROUTE,
    ) {
        composable(
            route = SEARCH_ROUTE,
        ) {
            SearchRoute(modifier = Modifier)
        }
    }
}
