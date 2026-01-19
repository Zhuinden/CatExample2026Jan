package com.zhuinden.catexample2026jan.features.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage

@Composable
fun DetailScreen(
    state: DetailState,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(32.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = state.text, fontSize = 25.sp)

            Spacer(modifier = Modifier.height(16.dp))

            AsyncImage(
                model = state.url,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun PreviewDetailScreen() {
    DetailScreen(
        state = DetailState(
            text = "Hello world",
            url = "https://img.freepik.com/premium-vector/google-icon_1273375-870.jpg?semt=ais_hybrid&w=740&q=80",
        )
    )
}
