package com.talento.domain

import com.talento.domain.model.Account
import io.reactivex.Single

interface IRepository {
    fun getAccounts(filterVisibleAccount: Boolean): Single<List<Account>>
}