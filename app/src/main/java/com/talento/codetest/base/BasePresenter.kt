package com.talento.codetest.base

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<View: BaseView>(private val view: View,
                                             private val mainThreadScheduler: Scheduler,
                                             private val backgroundThread: Scheduler): ScopePresenter {

    private val compositeDisposable = CompositeDisposable()

    protected fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    override fun onStop() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}
