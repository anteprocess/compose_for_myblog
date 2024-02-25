package com.anteprocess.basicmvvmfornoobs.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anteprocess.basicmvvmfornoobs.screen.main.usecase.CounterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor( private val counterUseCase: CounterUseCase): ViewModel() {

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
        viewModelScope.launch {
            when (event) {
                is OnClickCountUpEvent -> onClickCountUpEvent()
            }
        }
    }

    // Handle the OnClickCountUpEvent
    private suspend fun onClickCountUpEvent() {
        counterUseCase.incrementCounter()
        val newCounterValue = counterUseCase.getCounter()
        updateState(currentState().copy(counter = newCounterValue))
    }
}
