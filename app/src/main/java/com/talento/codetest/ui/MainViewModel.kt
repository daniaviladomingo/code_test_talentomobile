package com.talento.codetest.ui

import android.databinding.ObservableArrayList
import com.talento.codetest.base.BaseViewModel
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import com.talento.domain.model.Account

class MainViewModel(private val getAccountSingleUseCase: GetAccountSingleUseCase,
                    private val scheduleProvider: IScheduleProvider) : BaseViewModel() {

    val listAccount = ObservableArrayList<Account>()

    fun loadAccounts(filterVisibleAccount: Boolean) {
        disposable.add(getAccountSingleUseCase.execute(filterVisibleAccount)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    listAccount.run {
                        clear()
                        addAll(accounts)
                    }
                })
    }
}