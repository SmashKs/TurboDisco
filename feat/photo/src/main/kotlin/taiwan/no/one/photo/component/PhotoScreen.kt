package taiwan.no.one.photo.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PhotoRoute(modifier: Modifier = Modifier) {
    PhotoScreen(modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoScreen(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(text = "Camera")
        },
    )
}

@Preview
@Composable
fun PreviewSearchScreen() {
    MaterialTheme {
        PhotoScreen()
    }
}
