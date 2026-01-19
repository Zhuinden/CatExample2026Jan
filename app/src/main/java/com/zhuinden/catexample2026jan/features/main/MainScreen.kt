package com.zhuinden.catexample2026jan.features.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen(
    state: MainState,
    onButtonClicked: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = state.text,
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onButtonClicked,
            ) {
                Text(text = "Press me")
            }
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    MainScreen(
        state = MainState(text = "Hello world"),
        onButtonClicked = {},
    )
}