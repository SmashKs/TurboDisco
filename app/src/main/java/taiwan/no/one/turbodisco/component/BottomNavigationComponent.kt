package taiwan.no.one.turbodisco.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import taiwan.no.one.turbodisco.entity.bottomNavItems

@Composable
internal fun BottomNavigationComponent(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier,
    ) {
        bottomNavItems.forEachIndexed { index, bottomNavItem ->
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = bottomNavItem.selectedIcon,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavigationBar() {
    MaterialTheme {
        BottomNavigationComponent()
    }
}
