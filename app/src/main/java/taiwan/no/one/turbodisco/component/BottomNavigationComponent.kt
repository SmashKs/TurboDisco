package taiwan.no.one.turbodisco.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import taiwan.no.one.turbodisco.entity.TopLevelNavigationItem

@Composable
internal fun BottomNavigationComponent(
    modifier: Modifier = Modifier,
//    currentDestination: TopLevelNavigationItem?,
    onNavigateTopLevelScreen: (TopLevelNavigationItem) -> Unit = {},
) {
    var selectedItem = remember {
        TopLevelNavigationItem.EXPLORE
    }

    BottomAppBar(
        modifier = modifier,
    ) {
        TopLevelNavigationItem.entries.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItem == item,
                onClick = {
                    selectedItem = item
                    onNavigateTopLevelScreen(item)
                },
                icon = {
                    Icon(
                        imageVector = if (item == selectedItem) item.selectedIcon else item.unselectedIcon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelNavigationItem) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) == true
    } == true

@Preview
@Composable
private fun PreviewBottomNavigationBar() {
    MaterialTheme {
        BottomNavigationComponent()
    }
}
