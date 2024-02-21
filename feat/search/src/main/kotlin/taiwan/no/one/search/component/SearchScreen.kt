package taiwan.no.one.search.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
) {
    SearchScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = "Search")
        },
    )
}

@Preview
@Composable
private fun PreviewSearchScreen() {
    MaterialTheme {
        SearchScreen()
    }
}
