package com.talento.data.file

import com.talento.domain.model.Account
import io.reactivex.Single

interface IFileDataSource {
    fun getAccounts(filterVisibleAccounts: Boolean = false): Single<List<Account>>
}