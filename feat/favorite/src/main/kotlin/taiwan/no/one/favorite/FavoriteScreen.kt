package taiwan.no.one.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Favorite Screen") })
        },
    ) { paddingValues ->
        LazyColumn(
            modifier = modifier.padding(paddingValues),
        ) {
        }
    }
}

@Preview
@Composable
fun PreviewSearchScreen() {
    MaterialTheme {
        FavoriteScreen()
    }
}
