package com.talento.codetest.di.activity.module

import com.talento.codetest.di.activity.DaggerActivity
import com.talento.codetest.di.activity.PerActivity
import com.talento.codetest.ui.MainActivity
import com.talento.codetest.ui.MainContract
import com.talento.codetest.ui.MainPresenter
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val daggerActivity: DaggerActivity) {

    @Provides
    @PerActivity
    fun provideMainPresenter(getAccountSingleUseCase: GetAccountSingleUseCase, scheduleProvider: IScheduleProvider) : MainContract.IPresenter =
            MainPresenter(getAccountSingleUseCase, scheduleProvider, daggerActivity as MainActivity)
}