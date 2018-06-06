package com.talento.data.file

import com.google.gson.Gson
import com.talento.data.file.model.File
import com.talento.data.file.model.mapper.FileMapper
import com.talento.domain.model.Account
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class FileDataSourceImp(private val fileMapper: FileMapper,
                        private val inputStream: InputStream,
                        private val gson: Gson): IFileDataSource {

    override fun getAccounts(visibleAccount: Boolean): Single<List<Account>> = Single.create<List<Account>> {
        val textFile = BufferedReader(InputStreamReader(inputStream)).readText()
        val listAccountFile = gson.fromJson(textFile, File::class.java).accounts
        it.onSuccess(fileMapper.map(listAccountFile.filter { !visibleAccount || it.isVisible }))
    }
}