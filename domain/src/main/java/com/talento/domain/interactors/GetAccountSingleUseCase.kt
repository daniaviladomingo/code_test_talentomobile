package com.talento.domain.interactors

import com.talento.domain.IRepository
import com.talento.domain.model.Account
import com.test.domain.interactors.type.SingleUseCaseWithParameter

class GetAccountSingleUseCase(private val repository: IRepository): SingleUseCaseWithParameter<Boolean, List<Account>> {
    override fun execute(parameter: Boolean) = repository.getAccounts(parameter)
}