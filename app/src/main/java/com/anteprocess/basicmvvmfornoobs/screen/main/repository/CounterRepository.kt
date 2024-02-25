package com.anteprocess.basicmvvmfornoobs.screen.main.repository

// Repository interface
interface CounterRepository {
    suspend fun getCounter(): Int
    suspend fun incrementCounter()
}

// Implement Repository
class CounterRepositoryImpl : CounterRepository {
    private var counter: Int = 0

    override suspend fun getCounter(): Int {
        return counter
    }

    override suspend fun incrementCounter() {
        counter++
    }
}
