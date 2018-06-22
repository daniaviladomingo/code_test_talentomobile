package com.talento.codetest.di.modules

import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.codetest.utils.schedulers.ScheduleProviderImp
import dagger.Module
import dagger.Provides

@Module
class SchedulerModule {
    @Provides
    fun provideScheduleProvider(): IScheduleProvider = ScheduleProviderImp()
}