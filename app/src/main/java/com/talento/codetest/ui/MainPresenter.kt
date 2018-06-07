package com.talento.codetest.ui

import com.talento.codetest.base.BasePresenter
import com.talento.domain.interactors.GetAccountSingleUseCase
import io.reactivex.Scheduler

class MainPresenter(private val getAccountSingleUseCase: GetAccountSingleUseCase,
                    private val backgroundThread: Scheduler,
                    private val mainThreadScheduler: Scheduler): BasePresenter<MainContract.IView>(), MainContract.IPresenter {

    override fun init() {
        addDisposable(getAccountSingleUseCase.execute(false)
                .observeOn(backgroundThread)
                .subscribeOn(mainThreadScheduler)
                .subscribe { accounts ->
                    view.showUsers(accounts)
                })
    }
}