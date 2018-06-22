package com.talento.codetest.ui

import com.talento.codetest.base.BasePresenter
import com.talento.codetest.utils.schedulers.IScheduleProvider
import com.talento.domain.interactors.GetAccountSingleUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(
                    private val getAccountSingleUseCase: GetAccountSingleUseCase,
                    private val scheduleProvider: IScheduleProvider): BasePresenter<MainContract.IView>(), MainContract.IPresenter {

    override fun init() {
        addDisposable(getAccountSingleUseCase.execute(false)
                .observeOn(scheduleProvider.io())
                .subscribeOn(scheduleProvider.ui())
                .subscribe { accounts ->
                    view.showUsers(accounts)
                })
    }
}