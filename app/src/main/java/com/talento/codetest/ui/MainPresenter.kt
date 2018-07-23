package com.talento.codetest.ui

import com.talento.codetest.base.BasePresenter
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase

class MainPresenter(private val getAccountSingleUseCase: GetAccountSingleUseCase,
                    private val scheduleProvider: IScheduleProvider,
                    view: MainContract.IView) : BasePresenter<MainContract.IView>(view), MainContract.IPresenter {

    override fun init() {
        addDisposable(getAccountSingleUseCase.execute(false)
                .observeOn(scheduleProvider.io())
                .subscribeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    view.showUsers(accounts)
                })
    }
}