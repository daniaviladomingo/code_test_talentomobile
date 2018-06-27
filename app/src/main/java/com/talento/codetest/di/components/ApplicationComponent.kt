package com.talento.codetest.di.components

import android.content.Context
import com.talento.codetest.di.modules.*
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.data.file.IFileDataSource
import com.talento.domain.IRepository
import com.talento.domain.interactors.GetAccountSingleUseCase
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    DataModule::class,
    FileModule::class,
    SchedulerModule::class,
    UseCaseModule::class])

interface ApplicationComponent {

    fun provideContext(): Context

    fun provideDataSource(): IRepository

    fun provideFileDataSource(): IFileDataSource

    fun provideSchedule(): IScheduleProvider

    fun provideUseCase(): GetAccountSingleUseCase
}