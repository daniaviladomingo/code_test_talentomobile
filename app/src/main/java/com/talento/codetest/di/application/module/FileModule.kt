package com.talento.codetest.di.application.module

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.talento.codetest.R
import com.talento.data.file.FileDataSourceImp
import com.talento.data.file.IFileDataSource
import com.talento.data.file.model.AccountFile
import com.talento.data.file.model.mapper.FileMapper
import com.talento.domain.model.mapper.Mapper
import com.talento.domain.model.Account
import dagger.Module
import dagger.Provides
import java.io.InputStream
import javax.inject.Singleton

@Module
class FileModule {
    @Provides
    @Singleton
    fun provideFileDataSource(fileMapper: Mapper<AccountFile, Account>, inputStream: InputStream, gson: Gson): IFileDataSource = FileDataSourceImp(fileMapper, inputStream, gson)

    @Provides
    @Singleton
    fun provideFileMapper(): Mapper<AccountFile, Account> = FileMapper()

    @Provides
    @Singleton
    fun provideGsonParser(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideInputStream(context: Context): InputStream = context.resources.openRawResource(R.raw.account)
}