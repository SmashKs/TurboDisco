package taiwan.no.one.turbodisco.entity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.collections.immutable.persistentListOf

@Stable
internal data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

internal val bottomNavItems = persistentListOf(
    BottomNavItem(
        title = "maximus",
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Default.Favorite,
    ),
    BottomNavItem(
        title = "gp1kMl2IRA",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Default.Person,
    ),
    BottomNavItem(
        title = "xMTsGN1LVoA",
        selectedIcon = Icons.Filled.DateRange,
        unselectedIcon = Icons.Default.DateRange,
    ),
    BottomNavItem(
        title = "CharlesCheng",
        selectedIcon = Icons.Filled.LocationOn,
        unselectedIcon = Icons.Default.LocationOn,
    ),
)
