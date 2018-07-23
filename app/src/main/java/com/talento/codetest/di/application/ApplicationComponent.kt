package com.talento.codetest.di.application

import android.content.Context
import com.talento.codetest.AppApplication
import com.talento.codetest.di.application.module.*
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

    companion object {
        fun init(appApplication: AppApplication): ApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(appApplication))
                .build()
    }
}