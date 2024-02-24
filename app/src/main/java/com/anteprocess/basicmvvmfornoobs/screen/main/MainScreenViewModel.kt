package com.anteprocess.basicmvvmfornoobs.screen.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(): ViewModel() {

    // State is maintained using StateFlow
    private val _state = MutableStateFlow(MainScreenState.initValue)
    val state: StateFlow<MainScreenState> = _state.asStateFlow()

    // Function to get the current state
    private fun currentState(): MainScreenState = _state.value

    // Function to update the state
    private fun updateState(newState: MainScreenState) {
        _state.value = newState
    }

    // Process events sent from the view
    fun onEvent(event: MainViewEvent) {
        when (event) {
            is OnClickCountUpEvent -> onClickCountUpEvent()
        }
    }

    // Handle the OnClickCountUpEvent
    private fun onClickCountUpEvent() {
        val oldState = currentState()
        val newState = oldState.copy(counter = oldState.counter + 1)
        updateState(newState)
    }
}
