package taiwan.no.one.photo.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import taiwan.no.one.photo.component.PhotoRoute

private const val PHOTO_ROUTE = "photo_route"

fun NavController.navigateToPhoto(navOptions: NavOptions) = navigate(PHOTO_ROUTE, navOptions)

fun NavGraphBuilder.photoScreen() {
    composable(route = PHOTO_ROUTE) {
        PhotoRoute()
    }
}
