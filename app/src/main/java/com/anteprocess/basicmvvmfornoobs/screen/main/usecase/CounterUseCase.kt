package com.anteprocess.basicmvvmfornoobs.screen.main.usecase

import com.anteprocess.basicmvvmfornoobs.screen.main.repository.CounterRepository

// UseCase class
class CounterUseCase(private val repository: CounterRepository) {
    suspend fun getCounter(): Int {
        return repository.getCounter()
    }

    suspend fun incrementCounter() {
        repository.incrementCounter()
    }
}