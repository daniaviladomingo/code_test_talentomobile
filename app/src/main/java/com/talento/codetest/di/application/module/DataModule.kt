package com.talento.codetest.di.application.module

import com.talento.data.RepositoryImp
import com.talento.data.file.IFileDataSource
import com.talento.domain.IRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(fileDataSource: IFileDataSource) : IRepository = RepositoryImp(fileDataSource)
}