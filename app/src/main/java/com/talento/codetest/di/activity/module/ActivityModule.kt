package com.talento.codetest.di.activity.module

import com.talento.codetest.di.activity.PerActivity
import com.talento.codetest.ui.MainViewModel
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    @PerActivity
    fun provideMainViewModel(getAccountSingleUseCase: GetAccountSingleUseCase, scheduleProvider: IScheduleProvider): MainViewModel = MainViewModel(getAccountSingleUseCase, scheduleProvider)

}