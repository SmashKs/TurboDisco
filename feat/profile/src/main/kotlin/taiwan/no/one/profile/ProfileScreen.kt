package taiwan.no.one.profile

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun ProfileRoute(
    modifier: Modifier = Modifier,
) {
    ProfileScreen(modifier = modifier)
}

@Composable
internal fun ProfileScreen(
    modifier: Modifier = Modifier,
) {
}

@Preview
@Composable
private fun PreviewSearchScreen() {
    MaterialTheme {
        ProfileScreen()
    }
}
