package taiwan.no.one.turbodisco.entity

import androidx.compose.material.icons.Icons as MartialIcons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.persistentListOf
import taiwan.no.one.ds.icon.Icons
import taiwan.no.one.ds.icon.filled.Camera
import taiwan.no.one.ds.icon.outlined.Camera

@Stable
internal data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

internal val bottomNavItems = persistentListOf(
    BottomNavItem(
        title = "Explore",
        selectedIcon = MartialIcons.Filled.Search,
        unselectedIcon = MartialIcons.Outlined.Search,
    ),
    BottomNavItem(
        title = "Camera",
        selectedIcon = Icons.Filled.Camera,
        unselectedIcon = Icons.Outlined.Camera,
    ),
    BottomNavItem(
        title = "Favorite",
        selectedIcon = MartialIcons.Filled.Favorite,
        unselectedIcon = MartialIcons.Filled.FavoriteBorder,
    ),
    BottomNavItem(
        title = "Profile",
        selectedIcon = MartialIcons.Filled.AccountCircle,
        unselectedIcon = MartialIcons.Outlined.AccountCircle,
    ),
)
