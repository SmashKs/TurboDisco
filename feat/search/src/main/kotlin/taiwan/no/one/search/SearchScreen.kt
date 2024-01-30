package taiwan.no.one.search

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
fun SearchScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Search Screen") })
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
        SearchScreen()
    }
}