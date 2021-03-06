package com.talento.codetest.di.application.module

import com.talento.domain.IRepository
import com.talento.domain.interactors.GetAccountSingleUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {
    @Provides
    @Singleton
    fun provideGetAccountSingleUseCase(repository: IRepository) = GetAccountSingleUseCase(repository)
}