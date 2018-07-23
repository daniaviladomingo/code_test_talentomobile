package com.talento.codetest.di.application.module

import com.talento.codetest.ui.ViewModelFactory
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideViewModelFactory(getAccountSingleUseCase: GetAccountSingleUseCase, scheduleProvider: IScheduleProvider) : ViewModelFactory =
            ViewModelFactory(getAccountSingleUseCase, scheduleProvider)
}