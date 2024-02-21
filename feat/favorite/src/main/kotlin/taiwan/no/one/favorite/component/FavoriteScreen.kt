package taiwan.no.one.favorite.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FavoriteRoute(
    modifier: Modifier = Modifier,
) {
    FavoriteScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = "Favorite")
        },
    )
}

@Preview
@Composable
private fun PreviewSearchScreen() {
    MaterialTheme {
        FavoriteScreen()
    }
}
