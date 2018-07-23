package com.talento.data.file

import com.google.gson.Gson
import com.talento.data.file.model.AccountFile
import com.talento.data.file.model.File
import com.talento.domain.model.mapper.Mapper
import com.talento.domain.model.Account
import io.reactivex.Single
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class FileDataSourceImp(private val fileMapper: Mapper<AccountFile, Account>,
                        inputStream: InputStream,
                        private val gson: Gson): IFileDataSource {

    private val textFile: String = BufferedReader(InputStreamReader(inputStream)).readText()

    override fun getAccounts(filterVisibleAccounts: Boolean): Single<List<Account>> = Single.create<List<Account>> {
        val listAccountFile = gson.fromJson(textFile, File::class.java).accounts
        it.onSuccess(fileMapper.map(listAccountFile.filter { !filterVisibleAccounts || it.isVisible }))
    }
}