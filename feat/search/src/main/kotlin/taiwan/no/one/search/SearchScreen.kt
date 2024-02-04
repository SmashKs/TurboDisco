package taiwan.no.one.search

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
) {
    SearchScreen(modifier = modifier)
}

@Composable
internal fun SearchScreen(
    modifier: Modifier = Modifier,
) {
}

@Preview
@Composable
private fun PreviewSearchScreen() {
    MaterialTheme {
        SearchScreen()
    }
}
