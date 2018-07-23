package com.talento.codetest.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import com.talento.domain.model.Account
import io.reactivex.disposables.CompositeDisposable

class MainViewModule(private val getAccountSingleUseCase: GetAccountSingleUseCase,
                     private val scheduleProvider: IScheduleProvider) : ViewModel() {

    private val disposable = CompositeDisposable()

    var listAccount: MutableLiveData<List<Account>>? = null
        get() {
            field = field ?: MutableLiveData()
            loadAccounts()
            return field
        }

    override fun onCleared() {
        disposable.clear()
        super.onCleared()
    }

    private fun loadAccounts() {
        disposable.add(getAccountSingleUseCase.execute(false)
                .subscribeOn(scheduleProvider.io())
                .observeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    listAccount?.value = accounts
                })
    }
}