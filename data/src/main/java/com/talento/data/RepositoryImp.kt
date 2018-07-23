package com.talento.data

import com.talento.data.file.IFileDataSource
import com.talento.domain.IRepository

class RepositoryImp(private val fileDataSource: IFileDataSource): IRepository {
    override fun getAccounts(filterVisibleAccount: Boolean) = fileDataSource.getAccounts(filterVisibleAccount)
}