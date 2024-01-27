package taiwan.no.one.turbodisco.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun BottomNavigationComponent(modifier: Modifier = Modifier) {
    BottomAppBar(
        modifier = modifier,
    ) {
        repeat(4) {
            NavigationBarItem(
                selected = false,
                onClick = {},
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Call,
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
