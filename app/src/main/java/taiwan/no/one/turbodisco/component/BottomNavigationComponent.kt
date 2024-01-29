package taiwan.no.one.turbodisco.component

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import taiwan.no.one.turbodisco.entity.bottomNavItems

@Composable
internal fun BottomNavigationComponent(modifier: Modifier = Modifier) {
    var selectedIcon by remember { mutableStateOf(bottomNavItems.first()) }

    BottomAppBar(
        modifier = modifier,
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedIcon == item,
                onClick = {
                    selectedIcon = item
                },
                icon = {
                    Icon(
                        imageVector = if (item == selectedIcon) item.selectedIcon else item.unselectedIcon,
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
