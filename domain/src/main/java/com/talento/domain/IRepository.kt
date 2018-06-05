package com.talento.domain

import com.talento.domain.model.Account
import io.reactivex.Single

interface IRepository {
    fun getAccount(loadMore: Boolean): Single<List<Account>>
}