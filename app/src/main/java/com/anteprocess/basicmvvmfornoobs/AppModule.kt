package com.anteprocess.basicmvvmfornoobs

import com.anteprocess.basicmvvmfornoobs.screen.main.repository.CounterRepository
import com.anteprocess.basicmvvmfornoobs.screen.main.repository.CounterRepositoryImpl
import com.anteprocess.basicmvvmfornoobs.screen.main.usecase.CounterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideCounterRepository(): CounterRepository {
        return CounterRepositoryImpl()
    }

    @Provides
    fun provideCounterUseCase(repository: CounterRepository): CounterUseCase {
        return CounterUseCase(repository)
    }
}
