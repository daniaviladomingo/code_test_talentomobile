package com.talento.data.file.model.mapper

import com.talento.data.file.model.AccountFile
import com.talento.domain.mapper.Mapper
import com.talento.domain.model.Account

class FileMapper: Mapper<AccountFile, Account>() {
    override fun map(model: AccountFile) = model.run {
        Account(accountBalanceInCents, accountCurrency, accountId, accountName, accountNumber, accountType, alias, isVisible, iban)
    }

    override fun inverseMap(model: Account): AccountFile {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}