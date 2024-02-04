package taiwan.no.one.favorite

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteRoute(
    modifier: Modifier = Modifier,
) {
    FavoriteScreen(modifier = modifier)
}

@Composable
internal fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {
}

@Preview
@Composable
private fun PreviewSearchScreen() {
    MaterialTheme {
        FavoriteScreen()
    }
}
