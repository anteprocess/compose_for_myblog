package com.anteprocess.basicmvvmfornoobs.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreenContent(
    viewModel: MainScreenViewModel = hiltViewModel(),
) {
    // Collect state from the ViewModel
    val state by viewModel.state.collectAsState()

    // Pass events to the ViewModel via listeners
    MainScreen(
        state = state,
        onClickCountUp = { viewModel.onEvent(OnClickCountUpEvent) }
    )
}

@Composable
private fun MainScreen(
    state: MainScreenState,
    onClickCountUp: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MVVM simple project", modifier = Modifier.padding(bottom = 10.dp))
        // Trigger ViewModel event on button click
        Button(onClick = onClickCountUp,
            modifier = Modifier
                .padding(16.dp), // Optional padding
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray
            )) {
            Text(text = "My Counter")
        }
        // Display the counter from the state
        Text(text = "+${state.counter}")
    }
}
